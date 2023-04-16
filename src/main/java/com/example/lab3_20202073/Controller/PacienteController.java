package com.example.lab3_20202073.Controller;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Entity.PacienteEntity;
import com.example.lab3_20202073.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PacienteController {
    final PacienteRepository pacienteRepository;
    public PacienteController(PacienteRepository pacienteRepository){this.pacienteRepository=pacienteRepository;}
    @GetMapping("/listarPacientes")
    public String listarPacientes(Model model){
        List<PacienteEntity> lista = pacienteRepository.findAll();
        model.addAttribute("listaPacientes", lista);
        return "paciente/lista";
    }

    @GetMapping("/hospitalPacientes")
    public String pacientes(Model model, @RequestParam("id") Integer id){
        List<PacienteEntity> lista = pacienteRepository.buscarPacientes(id);
        model.addAttribute("listaPacientes", lista);
        return "paciente/lista";
    }

    @GetMapping("/doctorPacientes")
    public String pacientes2(Model model, @RequestParam("id") Integer id){
        List<PacienteEntity> lista = pacienteRepository.buscarPacientesDoctor(id);
        model.addAttribute("listaPacientes", lista);
        return "paciente/lista";
    }

    @GetMapping("/doctorPacientesAtender")
    public String pacientes3(Model model, @RequestParam("id") Integer id){
        List<PacienteEntity> lista = pacienteRepository.buscarPacientesAtender(id);
        model.addAttribute("listaPacientes", lista);
        return "paciente/lista";
    }
}
