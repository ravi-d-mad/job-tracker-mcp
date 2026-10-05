package com.jobtracker.mcp.model;

import com.jobtracker.mcp.repo.JobApplicationRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class JobTools {
    private final JobApplicationRepository repo;
    public JobTools(JobApplicationRepository repo) { this.repo = repo; }

    @Tool(description = "Log a new job application")
    public JobApplication addApplication(
            @ToolParam(description = "Company name") String company,
            @ToolParam(description = "Role title") String role,
            @ToolParam(description = "Job posting URL", required = false) String jobUrl) {
        return repo.save(new JobApplication(company, role, jobUrl, Status.APPLIED, LocalDate.now()));
    }

    @Tool(description = "List applications, optionally filtered by status")
    public List<JobApplication> listApplications(
            @ToolParam(description = "APPLIED, SCREENING, INTERVIEW, OFFER or REJECTED", required = false) Status status) {
        return status == null ? repo.findAll() : repo.findByStatus(status);
    }

    @Tool(description = "Applications whose follow-up date is today or earlier")
    public List<JobApplication> followUpsDue() {
        return repo.findByFollowUpOnLessThanEqual(LocalDate.now());
    }

    @Tool(description = "Update the status of an application by its id")
    public JobApplication updateStatus(
            @ToolParam(description = "Application id") Long id,
            @ToolParam(description = "APPLIED, SCREENING, INTERVIEW, OFFER or REJECTED") Status status) {
        JobApplication app = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No application with id " + id));
        app.setStatus(status);
        return repo.save(app);
    }
}