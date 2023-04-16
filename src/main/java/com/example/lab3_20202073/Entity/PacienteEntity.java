package com.example.lab3_20202073.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.print.Doc;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "paciente")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idPaciente;

    @Column(name = "nombre", length = 45)
    private String nombrePaciente;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "genero", length = 45)
    private String genero;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_cita")
    private LocalDate fechaCita;

    @Column(name = "diagnostico", length = 100)
    private String diagnostico;

    @Column(name = "numero_habitacion")
    private Integer numeroHabitacion;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;
}
