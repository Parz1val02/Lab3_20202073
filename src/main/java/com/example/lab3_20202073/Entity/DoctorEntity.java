package com.example.lab3_20202073.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idDoctor;

    @Column(name = "nombre", length = 50)
    private String nombreDoctor;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;
}
