
package com.colchonesBriones.Controller;

import com.colchonesBriones.Domain.Agenda;
import com.colchonesBriones.Service.AgendaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class AgendaController {
    
    @Autowired
    AgendaService agendaService;
    @GetMapping("/agenda/listado")
    public String inicio(Model model) {
       
       var agendas = agendaService.getAgendas();
       
        model.addAttribute("agendas", agendas);
        return "/agenda/listado";
    }
    @GetMapping("/agenda/nuevo")
    public String nuevoAgenda(Agenda agenda){
        return "/agenda/modificar";
    }
    @PostMapping("/agenda/guardar")
    public String guardarAgenda(Agenda agenda){
        agendaService.save(agenda);
        return "redirect:/agenda/listado";
    }
    @GetMapping("/agenda/modificar/{idCita}")
    public String modificarAgenda(Agenda agenda, Model model){
        agenda = agendaService.getAgenda(agenda);
        model.addAttribute("agenda", agenda);
        return "/agenda/modificar";
    }
    @GetMapping("/agenda/eliminar/{idAgenda}")
    public String elminarAgenda(Agenda agenda){
        agendaService.delete(agenda);
        return "redirect:/agenda/listado";
    }
    
}
