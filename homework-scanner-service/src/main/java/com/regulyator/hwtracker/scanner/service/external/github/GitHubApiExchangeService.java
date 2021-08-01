package com.regulyator.hwtracker.scanner.service.external.github;

import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.Repository;

import java.util.List;

public interface GitHubApiExchangeService {

    List<Repository> getUserRepositories(String userLogin);

    List<PullRequest> getPullRequests(String userLogin, String repositoryName);
}
