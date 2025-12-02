/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproyecto;

/**
 *
 * @author manue
 */
public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
    private boolean disponible;

    public Producto(String nombre, String categoria, double precio, int stock, boolean disponible) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isDisponible() {
        return disponible;
    }

    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + String.format("$%.2f", precio) +
                ", stock=" + stock +
                ", disponible=" + disponible +
                '}';
    }
}
