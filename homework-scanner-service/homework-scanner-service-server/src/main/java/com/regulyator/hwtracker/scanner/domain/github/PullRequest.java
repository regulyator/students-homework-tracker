package com.regulyator.hwtracker.scanner.domain.github;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {
    @JsonProperty("html_url")
    private String url;
    private Integer number;
    private String state;
    private List<Label> labels;
}
