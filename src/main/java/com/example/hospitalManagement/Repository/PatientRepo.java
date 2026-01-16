package com.example.hospitalManagement.Repository;

import com.example.hospitalManagement.DTO.BloodGroupCountDTO;
import com.example.hospitalManagement.Entity.Patient;
import com.example.hospitalManagement.Enum.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findByEmailOrName(String email, String name);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select  p from Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("select p.bloodGroup, count(p) from Patient p group by p.bloodGroup")
    List<Object[]> countOfEachBloodGroupType();

    @Query("select new com.example.hospitalManagement.DTO.BloodGroupCountDTO(p.bloodGroup, count(p)) from Patient p group by p.bloodGroup")
    List<BloodGroupCountDTO> countOfEachBloodGroupTypeUsingProjection();

    @Query(value = "select * from Patient", nativeQuery = true)
    List<Patient> findAllPatients();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
}
