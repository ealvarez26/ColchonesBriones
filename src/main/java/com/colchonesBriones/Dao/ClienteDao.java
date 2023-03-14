
package com.colchonesBriones.Dao;

import com.colchonesBriones.Domain.Cliente;
import org.springframework.data.repository.CrudRepository;



public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}

