package com.example.lab3_20202073.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="hospital")
public class HospitalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idHospital;

    @Column(name = "nombre", length = 50)
    private String nombreHospital;

    @Column(name = "direccion", length = 100)
    private String direccionHospital;

    @Column(name = "telefono", length = 45)
    private String telefonoHospital;
}
