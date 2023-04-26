
package com.colchonesBriones.Service;

import com.colchonesBriones.Domain.CarritoDetalle;
import com.colchonesBriones.Domain.Cliente;
import com.colchonesBriones.Domain.Usuario;
import java.util.List;


public interface ClienteService {
    
    public Cliente  getCliente(Long idCliente, Usuario usuario);
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);//Para insertar o modificar (Si viene el idCliente o no)
    
    public void delete(Cliente cliente);
    
    public List<Cliente> getClientes();
    
    public List<Cliente> getClienteD(Long idCliente);

}

