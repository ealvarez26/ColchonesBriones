package com.colchonesBriones.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne

    private Usuario usuario;
    

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Usuario usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.usuario = usuario;
        
        
    }
}
