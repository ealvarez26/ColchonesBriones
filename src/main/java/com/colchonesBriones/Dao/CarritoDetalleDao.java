
package com.colchonesBriones.Dao;

import com.colchonesBriones.Domain.Articulo;
import com.colchonesBriones.Domain.CarritoDetalle;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long>{
  
    List<CarritoDetalle> findByIdCarrito(Long idCarrito);
    
    CarritoDetalle findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo);
    
    void deleteByIdCarrito(Long idCarrito);
}