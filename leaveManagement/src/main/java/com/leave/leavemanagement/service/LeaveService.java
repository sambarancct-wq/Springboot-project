package com.leave.leavemanagement.service;

import com.leave.leavemanagement.model.Leave;
import com.leave.leavemanagement.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    } 

    public Optional<Leave> getLeaveById(Long id) {
        return leaveRepository.findById(id);
    }

    public Leave createLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(Long id, Leave updatedLeave) {
        return leaveRepository.findById(id).map(leave -> {
            leave.setEmployeeId(updatedLeave.getEmployeeId());
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setStatus(updatedLeave.getStatus());
            leave.setReason(updatedLeave.getReason());
            return leaveRepository.save(leave);
        }).orElseThrow(() -> new RuntimeException("Leave not found with id " + id));
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    public List<Leave> getLeavesByEmployeeId(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    public List<Leave> getLeavesByStatus(String status) {
        return leaveRepository.findByStatus(status);
    }

    public Leave approveLeave(Long id) {
        return leaveRepository.findById(id).map(leave -> {
            leave.setStatus("Approved");
            return leaveRepository.save(leave);
        }).orElseThrow(() -> new RuntimeException("Leave not found with id " + id));
    }

    public Leave rejectLeave(Long id) {
        return leaveRepository.findById(id).map(leave -> {
            leave.setStatus("Rejected");
            return leaveRepository.save(leave);
        }).orElseThrow(() -> new RuntimeException("Leave not found with id " + id));
    }
}