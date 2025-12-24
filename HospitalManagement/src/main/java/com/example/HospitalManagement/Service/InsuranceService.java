package com.example.HospitalManagement.Service;

import com.example.HospitalManagement.Entity.Insurance;
import com.example.HospitalManagement.Entity.Patient;
import com.example.HospitalManagement.Repository.InsuranceRepository;
import com.example.HospitalManagement.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //bidirectional consistency maintainence

        return patient;
    }

    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

        patient.setInsurance(null);
        return patient;
    }
}
