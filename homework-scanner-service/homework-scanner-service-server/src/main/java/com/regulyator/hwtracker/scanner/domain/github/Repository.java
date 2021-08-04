package com.regulyator.hwtracker.scanner.domain.github;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repository {
    private String name;
    private String fullName;
    private String description;
}
