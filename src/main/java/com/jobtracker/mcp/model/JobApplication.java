package com.jobtracker.mcp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String role;
    private String jobUrl;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate appliedOn;
    private LocalDate followUpOn;
    @Column(length = 2000)
    private String notes;

    protected JobApplication() {}

    public JobApplication(String company, String role, String jobUrl, Status status, LocalDate appliedOn) {
        this.company = company;
        this.role = role;
        this.jobUrl = jobUrl;
        this.status = status;
        this.appliedOn = appliedOn;
        this.followUpOn = appliedOn.plusDays(7); // default follow-up one week out
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getAppliedOn() {
        return appliedOn;
    }

    public void setAppliedOn(LocalDate appliedOn) {
        this.appliedOn = appliedOn;
    }

    public LocalDate getFollowUpOn() {
        return followUpOn;
    }

    public void setFollowUpOn(LocalDate followUpOn) {
        this.followUpOn = followUpOn;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", role='" + role + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
                ", status=" + status +
                ", appliedOn=" + appliedOn +
                ", followUpOn=" + followUpOn +
                ", notes='" + notes + '\'' +
                '}';
    }
}