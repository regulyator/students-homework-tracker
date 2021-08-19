package com.regulyator.hwtracker.scanner.service.external.github.impl;

import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.Repository;
import com.regulyator.hwtracker.scanner.service.external.github.GitHubApiExchangeService;
import com.regulyator.hwtracker.scanner.web.feign.GithubApiClient;
import feign.FeignException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
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
        try {
            return StringUtils.hasText(userLogin) ? githubApiClient.getAllUserRepositories(userLogin) : Collections.emptyList();
        } catch (FeignException feignException) {
            return Collections.emptyList();
        }
    }


    @Override
    @Cacheable(value = "pullRequestCache")
    public List<PullRequest> getPullRequests(String userLogin, String repositoryName) {
        try {
            return (StringUtils.hasText(userLogin)
                    && StringUtils.hasText(repositoryName)) ? githubApiClient.getAllOpenPullRequest(userLogin, repositoryName) : Collections.emptyList();
        } catch (FeignException feignException) {
            return Collections.emptyList();
        }

    }
}
