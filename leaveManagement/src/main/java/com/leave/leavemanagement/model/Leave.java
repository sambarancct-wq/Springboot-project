package com.leave.leavemanagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leaves")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId; // Assuming an employee ID
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType; // e.g., "Sick Leave", "Annual Leave"
    private String status; // e.g., "Pending", "Approved", "Rejected"
    private String reason;

    // Constructors
    //This has to have NO ARGUMENTS
    public Leave() {
    }

    public Leave(Long employeeId, LocalDate startDate, LocalDate endDate, String leaveType, String status, String reason) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
        this.reason = reason;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Leave{" +
               "id=" + id +
               ", employeeId=" + employeeId +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", leaveType='" + leaveType + '\'' +
               ", status='" + status + '\'' +
               ", reason='" + reason + '\'' +
               '}';
    }
}