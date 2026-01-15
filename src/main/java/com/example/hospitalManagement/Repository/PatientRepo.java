package com.example.hospitalManagement.Repository;

import com.example.hospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findByEmailOrName(String email, String name);
}
