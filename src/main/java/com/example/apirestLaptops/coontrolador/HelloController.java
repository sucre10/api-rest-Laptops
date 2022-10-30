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
        return "Hola desde HEROKU";
    }

    //------------------
    @GetMapping("/")  //inicio de la aplicacion
    public String entrada(){
        //return """
        //       """;
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola!</h1>
                    <h3>Esta es la página prncipal de la aplicacion</h3>
                    <h5>GRACIAS HEROKU</h5>
                    <a class="btn btn-primary"  href="https://www.google.com>Google</a>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
                  </body>
                </html>
                """;
    }
}
