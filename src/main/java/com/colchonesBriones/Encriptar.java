package com.colchonesBriones;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

    public static void main(String[] args) {

        var codigo = new BCryptPasswordEncoder();
        System.out.println("admin (123): " + codigo.encode("123"));
        System.out.println("Andres (123): " + codigo.encode("123"));
        System.out.println("oscar (123): " + codigo.encode("123"));
    }
}
