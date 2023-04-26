package com.colchonesBriones.Service;


import com.colchonesBriones.Dao.ClienteDao;
import com.colchonesBriones.Dao.UsuarioDao;
import com.colchonesBriones.Domain.Cliente;
import com.colchonesBriones.Domain.Usuario;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteDao clienteDao;
    
   @Autowired
   UsuarioDao usuarioDao;

   

    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Usuario usuario = cliente.getUsuario();
        usuario= usuarioDao.save(usuario);
        cliente.setUsuario(usuario);
        
        
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }

    @Override
    @Transactional
    public Cliente getCliente(Long idCliente, Usuario usuario) {
        return clienteDao.findByIdClienteAndUsuario(idCliente, usuario);
      
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClienteD(Long idCliente) {
        return clienteDao.findByIdCliente(idCliente);
    }
  
    
}
