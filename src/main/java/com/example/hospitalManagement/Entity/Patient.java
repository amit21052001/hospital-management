package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.web.servlet.ServletRegistration;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(
        name = "Patient_Table",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique_constraint", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    private LocalDate birthDate;
    private String email;
    private String gender;
}
