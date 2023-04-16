package com.example.lab3_20202073.Repository;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from paciente where hospital_id=?1")
    List<PacienteEntity> buscarPacientes(Integer id);

    @Query(nativeQuery = true, value = "select * from paciente where doctor_id=?1")
    List<PacienteEntity> buscarPacientesDoctor(Integer id);

    @Query(nativeQuery = true, value = "select * from paciente where doctor_id=?1 AND fecha_cita>current_date()")
    List<PacienteEntity> buscarPacientesAtender(Integer id);
}
