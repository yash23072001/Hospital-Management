package com.example.HospitalManagement.Repository;

import com.example.HospitalManagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}