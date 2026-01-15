package com.example.hospitalManagement;

import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.Repository.PatientRepo;
import com.example.hospitalManagement.Service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        Patient patient = new Patient();
        patient.setBirthDate(LocalDate.of(2026, 1, 1));
        patient.setGender("Male");
        patient.setName("Amit");
        patient.setEmail("Test#gmail.com");

        patientRepo.save(patient);

        List<Patient> patients = patientRepo.findAll();
        System.out.println(patients);
    }

    @Test
    public void testTransactionalMethods() {
//        Patient p1 = patientService.getPatientById(1L);
//        System.out.println(p1);

//        Patient patient = patientRepo.findByName("Anang");
//        System.out.println(patient);
        List<Patient> patients = patientRepo.findByEmailOrName("Gagan@gmail.com", "Amit");
        for (Patient patient : patients) {
            System.out.println(patient);
        }

    }
}
