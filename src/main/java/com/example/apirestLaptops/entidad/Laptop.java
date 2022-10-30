package com.example.apirestLaptops.entidad;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    //Atributos
    @Id
    //para que las claves se generen automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroDeSerie;
    private String marca;
    private  String procesador;
    private String sistemaOperativo;
    private Integer memoriaRam;
    private Double precio;

    // CONSTRUCTOR
    //vacio
    public Laptop() {
    }

    public Laptop(Long id, Integer numeroDeSerie, String marca, String procesador, String sistemaOperativo, Integer memoriaRam, Double precio) {
        this.id = id;
        this.numeroDeSerie = numeroDeSerie;
        this.marca = marca;
        this.procesador = procesador;
        this.sistemaOperativo = sistemaOperativo;
        this.memoriaRam = memoriaRam;
        this.precio = precio;
    }

    // getter and setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Integer numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
