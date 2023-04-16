package com.example.lab3_20202073.Repository;

import com.example.lab3_20202073.Entity.HospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {
}
