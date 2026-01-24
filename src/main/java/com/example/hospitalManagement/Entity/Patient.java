package com.example.hospitalManagement.Entity;

import com.example.hospitalManagement.Enum.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.web.servlet.ServletRegistration;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(
//        name = "Patient_Table",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "email_unique_constraint", columnNames = {"email"}),
//                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
//        },
//        indexes = {
//                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
//        }
//)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "FIRST_NAME", nullable = false, length = 40)
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne
    @JoinColumn(name = "Patient_Insurance_Id") //owning side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;
}
