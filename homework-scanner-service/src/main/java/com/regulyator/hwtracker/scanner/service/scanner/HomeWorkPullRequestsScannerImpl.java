package com.regulyator.hwtracker.scanner.service.scanner;

import com.regulyator.hwtracker.scanner.service.external.dataservice.DataServiceApiExchangeService;
import com.regulyator.hwtracker.scanner.service.external.github.GitHubApiExchangeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HomeWorkPullRequestsScannerImpl implements HomeWorkPullRequestsScanner {
    private final DataServiceApiExchangeService dataServiceApiExchangeService;
    private final GitHubApiExchangeService gitHubApiExchangeService;

    public HomeWorkPullRequestsScannerImpl(DataServiceApiExchangeService dataServiceApiExchangeService,
                                           GitHubApiExchangeService gitHubApiExchangeService) {
        this.dataServiceApiExchangeService = dataServiceApiExchangeService;
        this.gitHubApiExchangeService = gitHubApiExchangeService;
    }

    @Override
    @Scheduled(cron = "${com.hwtracker.githubscanner.schedule.cronrate:0 0 0/1 1/1 * ?}")
    public void scanHomeWorksPullRequests() {

    }
}
