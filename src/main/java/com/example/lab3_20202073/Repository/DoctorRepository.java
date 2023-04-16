package com.example.lab3_20202073.Repository;

import com.example.lab3_20202073.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from doctor where hospital_id=?1")
    List<DoctorEntity> buscarDoctores(Integer id);
}
