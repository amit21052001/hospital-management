package com.example.hospitalManagement.Repository;

import com.example.hospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
