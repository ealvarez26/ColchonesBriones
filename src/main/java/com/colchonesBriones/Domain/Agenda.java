

package com.colchonesBriones.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name="cita")
public class Agenda implements Serializable {
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
     private Long idCita;
     private String descripcion;
     @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private String fecha;
    private String hora;
    
    




    public Agenda() {
    }

    public Agenda(String descripcion, String fecha, String hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        
    }

    

    
    
    
}