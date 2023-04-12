package com.example.lab3_20202073.Repository;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {
    @Query(value = "select * from doctor where hospital_id=?1;",
            nativeQuery = true)
    List<DoctorEntity> buscarDoctores(Integer id);
}
