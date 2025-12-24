package com.example.HospitalManagement;

import com.example.HospitalManagement.Entity.Patient;
import com.example.HospitalManagement.Entity.type.BloodGroupType;
import com.example.HospitalManagement.Repository.PatientRepository;
import com.example.HospitalManagement.Service.PatientService;
import com.example.HospitalManagement.dto.BloodGroupCountResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PatientTests {

    @Autowired
    private  PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void TestPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);


//        Patient patient = patientRepository.findByName("Yash Paliwal");
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1970, 9, 14));

        Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0, 2, Sort.by("name")));
        for(Patient patient: patientList){
            System.out.println(patient);
        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList){
//            System.out.println(objects[0] + " " + objects[1]);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Yash Paliwal", 29L);
//        System.out.println(rowsUpdated);

//        //Projection used here
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupList){
//            System.out.println(bloodGroupCountResponse);
//        }
    }


}
