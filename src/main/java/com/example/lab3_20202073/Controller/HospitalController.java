package com.example.lab3_20202073.Controller;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Entity.HospitalEntity;
import com.example.lab3_20202073.Repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository hospitalRepository){this.hospitalRepository=hospitalRepository;}

    @GetMapping(value = {"/listarHospitales","/"})
    public String listarHospitales(Model model){
        List<HospitalEntity> lista = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", lista);
        return "hospital/lista";
    }

}
