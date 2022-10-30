/**
 * Nombre: Milton Soto Martínez
 * Asignatura: Spring
 * Tarea, seción 4, 5, 6
 * OpenBootCamp
 * 21/10/2022
 */

package com.example.apirestLaptops;

import com.example.apirestLaptops.entidad.Laptop;
import com.example.apirestLaptops.repositorio.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Los objetos Laptop se pueden insertar desde el método main de la clase principal.
 */



@SpringBootApplication	//habilita el scaneo de todo los paquetes,
						// creando objetos de cada clase encontrada que tenga alguna anotacion
public class ApiRestLaptopsApplication {

	public static void main(String[] args) {

		//.........................
		ApplicationContext context = SpringApplication.run(ApiRestLaptopsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		//..........................

		//OPERACIONES CRUD
		//Crear Laptos
		Laptop lapto1 = new Laptop(null,124578254,"Dell","Intel Core i2","Windows 8.1", 2, 1000.0);
		Laptop lapto2 = new Laptop(null,165478965,"Lenovo","Intel Core i7","Windows 10", 2, 1500.0);
		Laptop lapto3 = new Laptop(null,587215469,"HP","Intel Core i5","Windows 8.1", 2, 1200.0);

		// Almacenar Laptops
		System.out.println("Número de Laptops: "+ repository.findAll().size());
		System.out.println("Número de Laptops: "+ repository.count());

		repository.save(lapto1);
		repository.save(lapto2);
		repository.save(lapto3);

		System.out.println("Número de Laptops: "+ repository.findAll().size());
	}

}
