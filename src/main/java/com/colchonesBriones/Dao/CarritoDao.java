
package com.colchonesBriones.Dao;

import com.colchonesBriones.Domain.Carrito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


    public interface CarritoDao extends CrudRepository<Carrito, Long>{
  Optional<Carrito> findByIdCliente(Long idCliente);
}

