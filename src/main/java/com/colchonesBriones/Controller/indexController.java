package com.colchonesBriones.Controller;

import com.colchonesBriones.Dao.UsuarioDao;
import com.colchonesBriones.Domain.Carrito;
import com.colchonesBriones.Domain.CarritoDetalle;
import com.colchonesBriones.Domain.Usuario;
import com.colchonesBriones.Service.ArticuloService;
import com.colchonesBriones.Service.CarritoDetalleService;
import com.colchonesBriones.Service.CarritoService;
import com.colchonesBriones.Service.CategoriaService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Slf4j
@Controller
public class indexController {
   @Autowired
    ArticuloService articuloService;

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    CarritoService carritoService;

    @Autowired
    CarritoDetalleService carritoDetalleService;

    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;

        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }

        boolean esCliente = false;

        if (user != null) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());

            if (usuario.getIdCliente() != null && usuario.getIdCliente() != 0 ){
                
                esCliente = true;

                Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());

                request.getSession().setAttribute("idCliente", usuario.getIdCliente());
                request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
                request.getSession().setAttribute("esCliente", esCliente);

                List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
                model.addAttribute("cantidadArticulosCarrito", carritoDetalles.size());
            }

        }
        var articulos = articuloService.getArticulos(true);

        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);

        return "/categoria/listado";
    }
}
    
