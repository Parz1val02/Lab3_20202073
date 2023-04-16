package com.example.lab3_20202073.Controller;

import com.example.lab3_20202073.Entity.DoctorEntity;
import com.example.lab3_20202073.Entity.PacienteEntity;
import com.example.lab3_20202073.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/editarPaciente")
    public String editarPaciente(Model model, @RequestParam("id") Integer id) {

        Optional<PacienteEntity> optionalPaciente = pacienteRepository.findById(id);

        if (optionalPaciente.isPresent()) {
            PacienteEntity paciente = optionalPaciente.get();
            model.addAttribute("paciente", paciente);
            return "paciente/editar";
        } else {
            return "redirect:/listarPacientes";
        }
    }
    @PostMapping("/guardarE")
    public String editar(@RequestParam("idPaciente") Integer id,
                         @RequestParam("numeroHabitacion") Integer num){
        pacienteRepository.actualizarNumeroHabitacion(id, num);
        return "redirect:/listarPacientes";
    }

    @PostMapping("/guardarD")
    public String derivar(@RequestParam("id1") Integer id1,
                         @RequestParam("id2") Integer id2){
        pacienteRepository.derivarPacientes(id1, id2);
        Integer d1 = pacienteRepository.buscarHospitales(id1);
        Integer d2= pacienteRepository.buscarHospitales(id2);
        pacienteRepository.derivarPacientes2(d1,d2, id2);
        return "redirect:/listarPacientes";
    }
}
