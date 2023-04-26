package com.colchonesBriones.Dao;

import com.colchonesBriones.Domain.Cliente;
import com.colchonesBriones.Domain.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {

    public List<Cliente> findByApellidos(String apellidos);

    Cliente findByIdClienteAndUsuario(Long idCliente, Usuario usuario);

    List<Cliente> findByIdCliente(Long idCliente);

}
