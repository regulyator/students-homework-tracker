package com.regulyator.hwtracker.scanner.service.external.github.impl;

import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.Repository;
import com.regulyator.hwtracker.scanner.service.external.github.GitHubApiExchangeService;
import com.regulyator.hwtracker.scanner.web.feign.GithubApiClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubApiExchangeServiceImpl implements GitHubApiExchangeService {
    private final GithubApiClient githubApiClient;

    public GitHubApiExchangeServiceImpl(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;
    }

    @Override
    @Cacheable(value = "repositoryCache")
    public List<Repository> getUserRepositories(String userLogin) {
        return githubApiClient.getAllUserRepositories(userLogin);
    }

    @Override
    @Cacheable(value = "pullRequestCache")
    public List<PullRequest> getPullRequests(String userLogin, String repositoryName) {
        return githubApiClient.getAllOpenPullRequest(userLogin, repositoryName);
    }
}
