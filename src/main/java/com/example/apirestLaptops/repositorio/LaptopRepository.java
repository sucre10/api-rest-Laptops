package com.example.apirestLaptops.repositorio;

import com.example.apirestLaptops.entidad.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio para la base de datos Laptops
@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    //extends JpaRepository<Laptop, Long>... nos proporciona los métodos CRUD
    //nos facilita realizar la base de datos con pocas lineas de codigo
}
