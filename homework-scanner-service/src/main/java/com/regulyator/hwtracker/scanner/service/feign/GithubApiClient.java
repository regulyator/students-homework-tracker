package com.regulyator.hwtracker.scanner.service.feign;

import com.regulyator.hwtracker.scanner.domain.github.PullRequest;
import com.regulyator.hwtracker.scanner.domain.github.Repository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "github", url = "https://api.github.com/")
public interface GithubApiClient {

    @GetMapping(path = "users/{userLogin}/repos")
    List<Repository> getAllUserRepositories(@PathVariable String userLogin);

    @GetMapping(path = "repos/{userLogin}/{repositoryName}/pulls")
    List<PullRequest> getAllOpenPullRequest(@PathVariable String userLogin, @PathVariable String repositoryName);
}
