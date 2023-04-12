package com.example.lab3_20202073.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {
    @GetMapping("/listarPacientes")
    public String listarPacientes(){
        return "paciente/listar";
    }
}
