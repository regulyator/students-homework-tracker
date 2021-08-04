package com.regulyator.hwtracker.scanner.domain.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {
    private String url;
    private Integer number;
    private String state;
}
