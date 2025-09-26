package com.leave.leavemanagement.repository;

import com.leave.leavemanagement.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    //The above means "I am using JpaRepository to perform CRUD operations"
    //<leave,long> means I am using leave model with primary key have type long
    List<Leave> findByEmployeeId(Long employeeId);
    List<Leave> findByStatus(String status);
}