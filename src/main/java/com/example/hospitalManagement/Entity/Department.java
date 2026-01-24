package com.example.hospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "Department_Doctor",
            joinColumns = @JoinColumn(name = "Department_ID"),
            inverseJoinColumns = @JoinColumn(name = "Doctor_ID")
    )
    private Set<Doctor> doctors = new HashSet<>(); //When hibernate fill this field, it doesn't find this null;
}
