package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 100)
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;

    @ManyToMany(mappedBy = "doctors")
    private Set<Doctor> doctors;

}
