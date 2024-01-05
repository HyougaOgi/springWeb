package com.example.springWeb.web.issue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class IssueForm {
    @NotBlank
    @Size(max=256)
    private String summary;
    @NotBlank
    @Size(max=256)
    private String description;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
