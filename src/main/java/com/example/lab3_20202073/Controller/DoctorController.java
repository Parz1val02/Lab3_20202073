package com.example.lab3_20202073.Controller;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {
    final DoctorRepository doctorRepository;
    public DoctorController(DoctorRepository doctorRepository){this.doctorRepository=doctorRepository;}
    @GetMapping("/listarDoctores")
    public String listarDoctores(Model model){
        List<DoctorEntity> lista = doctorRepository.findAll();
        model.addAttribute("listaDoctores", lista);
        return "doctor/lista";
    }
}
