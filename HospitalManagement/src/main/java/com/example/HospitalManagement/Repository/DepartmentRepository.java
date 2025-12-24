package com.example.HospitalManagement.Repository;

import com.example.HospitalManagement.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}