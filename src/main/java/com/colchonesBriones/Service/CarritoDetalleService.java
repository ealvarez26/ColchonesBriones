
package com.colchonesBriones.Service;

import com.colchonesBriones.Domain.Articulo;
import com.colchonesBriones.Domain.CarritoDetalle;
import java.util.List;

public interface CarritoDetalleService {
 
    public CarritoDetalle getCarritoDetalle(Long idCarrito, Articulo articulo);
    
    public List<CarritoDetalle> getCarritoDetalles(Long idCarrito);
    
    public void save(CarritoDetalle carritoDetalle);
    
    public void delete(CarritoDetalle carritoDetalle);
      
     public void deleteAll(Long idCarrito);
}