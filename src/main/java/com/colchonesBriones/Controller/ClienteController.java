package com.colchonesBriones.Controller;


import com.colchonesBriones.Dao.ClienteDao;
import com.colchonesBriones.Domain.Cliente;
import com.colchonesBriones.Service.ClienteService;
import jakarta.servlet.http.HttpSession;


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
public class ClienteController {
    @Autowired
    ClienteDao clienteDao;
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model, HttpSession session) {
       Long idCliente = (Long) session.getAttribute("idCliente");
        
        List<Cliente> cliente = clienteService.getClienteD(idCliente);
        
        
        var clientes = clienteService.getClientes();
        
        model.addAttribute("cliente", cliente);
  
        model.addAttribute("clientes", clientes);
        model.addAttribute("totalClientes",clientes.size());
        
        
        return "/cliente/listado";
    }
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modificar";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String elminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    
}

