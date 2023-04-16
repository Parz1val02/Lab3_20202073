package com.example.lab3_20202073.Repository;

import com.example.lab3_20202073.Entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {

    @Query(nativeQuery = true, value = "select * from paciente where hospital_id=?1")
    List<PacienteEntity> buscarPacientes(Integer id);

    @Query(nativeQuery = true, value = "select * from paciente where doctor_id=?1")
    List<PacienteEntity> buscarPacientesDoctor(Integer id);

    @Query(nativeQuery = true, value = "select * from paciente where doctor_id=?1 AND fecha_cita>current_date()")
    List<PacienteEntity> buscarPacientesAtender(Integer id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update paciente set numero_habitacion = ?2 where id = ?1")
    void actualizarNumeroHabitacion(Integer id, Integer num);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update paciente set doctor_id = ?2 where doctor_id = ?1")
    void derivarPacientes(Integer id1, Integer id2);


    @Query(nativeQuery = true, value = "select hospital_id from doctor where id=?1")
    Integer buscarHospitales(Integer id);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update paciente set hospital_id = ?2 where hospital_id = ?1 and doctor_id = ?3")
    void derivarPacientes2(Integer id1, Integer id2, Integer id3);
}
