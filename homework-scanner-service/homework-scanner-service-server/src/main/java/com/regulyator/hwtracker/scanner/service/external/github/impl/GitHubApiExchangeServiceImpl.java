package com.regulyator.hwtracker.scanner.service.external.github.impl;

import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.Repository;
import com.regulyator.hwtracker.scanner.service.external.github.GitHubApiExchangeService;
import com.regulyator.hwtracker.scanner.service.feign.GithubApiClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubApiExchangeServiceImpl implements GitHubApiExchangeService {
    private final GithubApiClient githubApiClient;

    public GitHubApiExchangeServiceImpl(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;
    }

    @Override
    public List<Repository> getUserRepositories(String userLogin) {
        return githubApiClient.getAllUserRepositories(userLogin);
    }

    @Override
    public List<PullRequest> getPullRequests(String userLogin, String repositoryName) {
        return githubApiClient.getAllOpenPullRequest(userLogin, repositoryName);
    }
}
