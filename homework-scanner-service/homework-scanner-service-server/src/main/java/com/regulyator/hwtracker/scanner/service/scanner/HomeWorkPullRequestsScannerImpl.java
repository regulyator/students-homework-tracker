package com.regulyator.hwtracker.scanner.service.scanner;

import com.regulyator.hwtracker.data.dto.StudentHomeworkInformationDto;
import com.regulyator.hwtracker.scanner.domain.github.Label;
import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.PullRequestState;
import com.regulyator.hwtracker.scanner.service.data.PullRequestVerifyTaskService;
import com.regulyator.hwtracker.scanner.service.external.github.GitHubApiExchangeService;
import com.regulyator.hwtracker.scanner.service.external.homework.HomeWorkApiExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeWorkPullRequestsScannerImpl implements HomeWorkPullRequestsScanner {
    private final HomeWorkApiExchangeService homeWorkApiExchangeService;
    private final GitHubApiExchangeService gitHubApiExchangeService;
    private final PullRequestVerifyTaskService pullRequestVerifyTaskService;

    @Autowired
    public HomeWorkPullRequestsScannerImpl(HomeWorkApiExchangeService homeWorkApiExchangeService,
                                           GitHubApiExchangeService gitHubApiExchangeService,
                                           PullRequestVerifyTaskService pullRequestVerifyTaskService) {
        this.homeWorkApiExchangeService = homeWorkApiExchangeService;
        this.gitHubApiExchangeService = gitHubApiExchangeService;
        this.pullRequestVerifyTaskService = pullRequestVerifyTaskService;
    }


    @Override
    @Scheduled(cron = "${com.hwtracker.githubscanner.schedule.cronrate:0 0 0/1 1/1 * ?}")
    public void scanHomeWorksPullRequests() {
        var activeHomeWorks = homeWorkApiExchangeService.getAllHomeWorks(true);
        activeHomeWorks.forEach(homeWork -> {
            final var homeworkLabel = new Label(homeWork.getHomeworkTag());
            homeWork.getStudents().forEach(studentHomeworkInformation -> {
                final var studentPullRequests = getStudentsPullRequests(studentHomeworkInformation);
                studentPullRequests.stream().filter(pullRequest -> isUnprocessedHwPullRequest(homeworkLabel, pullRequest))
                        .forEach(pullRequest ->
                                pullRequestVerifyTaskService.save(pullRequest, homeWork, studentHomeworkInformation.getStudentId()));
            });
        });
    }

    private boolean isUnprocessedHwPullRequest(Label homeworkLabel, PullRequest pullRequest) {
        return pullRequest.getState().equals(PullRequestState.OPEN.getState())
                && pullRequest.getLabels().contains(homeworkLabel)
                && !pullRequestVerifyTaskService.existsByPullRequestUrl(pullRequest.getUrl());
    }

    private List<PullRequest> getStudentsPullRequests(StudentHomeworkInformationDto studentHomeworkInformationDto) {
        return gitHubApiExchangeService
                .getPullRequests(studentHomeworkInformationDto.getGithubUserName(),
                        studentHomeworkInformationDto.getHomeworkRepositoryUrl());
    }
}
