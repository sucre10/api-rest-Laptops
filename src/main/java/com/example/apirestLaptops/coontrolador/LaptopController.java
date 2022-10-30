package com.example.apirestLaptops.coontrolador;

import com.example.apirestLaptops.entidad.Laptop;
import com.example.apirestLaptops.repositorio.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // Atributos
    public LaptopRepository laptopRepository;

    // Constructores

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     * findAll() :   Buscar lista de LAPTOS
     *
     * Buscamos todas las Laptop que hay en la base de datos (devuelve un ArrayList)
     *  request : peticion
     *  Response : Respuesta
     *  http://localhost:8081/api/laptop
     *  @return
     */

    @GetMapping("/api/laptop")
    public List<Laptop> finAll(){
        return laptopRepository.findAll();
    }

    /**
     *  findOneById():  Lista de laptop por Id
     *
     *  Request : peticion
     *  Response : Respuesta
     * @param id
     *  http://localhost:8081/api/laptop/1
     *  @return
     */

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        //Buscamos la Laptop en el repositorio
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        // opcion 1
        if(laptopOptional.isPresent())
            // return Laptop encontrada
            return ResponseEntity.ok(laptopOptional.get());
        else
            //return   notFound() equivale a 404
            return ResponseEntity.notFound().build();
    }

    /**
     * create():   Crear Nuevo Laptop en base de datos
     * Método POST
     *
     * @param laptop
     * @param headers
     * @return
     */
    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop>  create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent")); //User-Agent ... permitira ver quien envia la informacion , tipo de dispositivo, ...

        //guardar Laptop recibido en la base de datos:
        if (laptop.getId()!=null){
            log.warn("Laptop almacenado en base de datos con id");  //imprime mensajes con mayor informacion
            System.out.println("Laptop almacenado en base de datos con id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);          //Guardado correctamente
        return ResponseEntity.ok(result);
    }


    /**
     * update(): Actualizar Laptop de la base de datos

     * ResponseEntity : es una clase de spring que devuelve mucha informacion, como cabeceras, etc
     */
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop>  update(@RequestBody Laptop laptop){

        //se ha enviado sin id
        if ((laptop.getId() == null)) {
            log.warn("Su dato no tiene Id");
            return ResponseEntity.badRequest().build();//badRequest(): retorna 400
        }

        //se ha enviado con ID
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Este id no existe en la base de datos para actualizar");
            return ResponseEntity.notFound().build();//notFound(): retorna 404
        }
        //caso contrario tiene ID y existe la Laptop en base de datos
        // El proceso de actualizacion
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); //retorna   ok  200
    }


    /**
     * delete(): Borrar por Id
     *
     * Borrar datos segun ID
     * @param id
     * @return
     */

    @DeleteMapping("/api/laptop/{id}")

    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        //existe el id que quiere borrar en la base de datos?
        if(!laptopRepository.existsById(id)){
            log.warn("No existe esta Laptop en la base de datos");
            return ResponseEntity.notFound().build(); //notFound(): retorna 404 o existe
        }
        //caso contrario si existe este id en base de datos
        laptopRepository.deleteById(id);                 //borrado
        return ResponseEntity.noContent().build(); // noContent():  devuelve error 204
    }


    /**
     * deleteAll(): Borrar todo
     *
     * Borrar todos los datos
     * @return
     */

    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request borrar toda las Laptops de la base de datos");
        // log.info(""): muestra la informacion delo que se esta ejecutando
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();   // noContent():  devuelve error 204
    }

}
