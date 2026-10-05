package com.jobtracker.mcp.repo;

import com.jobtracker.mcp.model.JobApplication;
import com.jobtracker.mcp.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(Status status);
    List<JobApplication> findByFollowUpOnLessThanEqual(LocalDate date);
}
