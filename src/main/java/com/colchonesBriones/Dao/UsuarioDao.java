
package com.colchonesBriones.Dao;

import com.colchonesBriones.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
 Usuario findByUsername(String username);  
}
