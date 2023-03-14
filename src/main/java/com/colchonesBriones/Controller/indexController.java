package com.colchonesBriones.Controller;

import com.colchonesBriones.Service.AgendaService;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class indexController {
    @Autowired
    AgendaService agendaService;
    
   
    
    @GetMapping("/")
    public String inicio(Model model) {
       
       var agendas = agendaService.getAgendas();
       
        model.addAttribute("agendas", agendas);
        return "/agenda/listado";
    }
    
    }
