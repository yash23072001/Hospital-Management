package com.example.HospitalManagement.Service;

import com.example.HospitalManagement.Entity.Appointment;
import com.example.HospitalManagement.Entity.Doctor;
import com.example.HospitalManagement.Entity.Patient;
import com.example.HospitalManagement.Repository.AppointmentRepository;
import com.example.HospitalManagement.Repository.DoctorRepository;
import com.example.HospitalManagement.Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment should not have");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment); // To maintain consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment ReAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // Ths will automatically call the update, because it is dirty

        return appointment;
    }
}
