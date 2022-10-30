package com.example.apirestLaptops.coontrolador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //atributos

    //constructores

    //metodos

    /**
     * http://localhost:8081/saludo
     * @return
     */
    @GetMapping("/saludo")
    public String Saludo(){
        return "Hola esta es la tarea SECIOON 4, 5, 6";
    }

}
