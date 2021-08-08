package com.regulyator.hwtracker.scanner.domain.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {
    private String url;
    private Integer number;
    private String state;
    private List<Label> labels;
}
