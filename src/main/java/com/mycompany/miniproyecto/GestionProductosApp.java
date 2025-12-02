/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproyecto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author manue
 */


public class GestionProductosApp {

    private static List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        // 1. Cargar datos iniciales
        inicializarInventario();


        // Tarea 1: Mostrar el catalogo
        Runnable mostrarCatalogo = () -> {
            // Usamos forEach funcional
            inventario.forEach(System.out::println);
        };

        // Tarea 2: Calcular estadisticas usando Streams
        Runnable calcularEstadisticas = () -> {
            // Precio promedio de productos disponibles
            double promedio = inventario.stream()
                    .filter(Producto::isDisponible)
                    .mapToDouble(Producto::getPrecio)
                    .average()
                    .orElse(0.0);

            // Numero total de productos en stock 
            int totalStock = inventario.stream()
                    .mapToInt(Producto::getStock)
                    .sum();

            // Producto mas caro
            Optional<Producto> masCaro = inventario.stream()
                    .max(Comparator.comparing(Producto::getPrecio));

            // Producto mas barato
            Optional<Producto> masBarato = inventario.stream()
                    .min(Comparator.comparing(Producto::getPrecio));

            System.out.println("Estadísticas del Inventario:");
            System.out.printf("- Precio promedio (disponibles): $%.2f%n", promedio);
            System.out.println("- Total de stock en almacén: " + totalStock);
            masCaro.ifPresent(p -> System.out.println("- Producto más caro: " + p.getNombre() + " ($" + p.getPrecio() + ")"));
            masBarato.ifPresent(p -> System.out.println("- Producto más barato: " + p.getNombre() + " ($" + p.getPrecio() + ")"));
        };

        // Tarea 3: Aplicar descuento y mostrar modificados
        Runnable aplicarDescuento = () -> {
            String categoriaObjetivo = "Electrónica";
            double porcentajeDescuento = 0.10; // 10%

            System.out.println("Aplicando 10% de descuento a: " + categoriaObjetivo);
            
            inventario.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoriaObjetivo))
                    .peek(p -> {
                        double nuevoPrecio = p.getPrecio() * (1.0 - porcentajeDescuento);
                        p.setPrecio(nuevoPrecio);
                    })
                    .forEach(p -> System.out.println("Descuento aplicado -> " + p));
        };

        
        
        // Ejecutar Tarea 1
        ejecutarOperacion("Mostrar Catálogo Completo", mostrarCatalogo);

        // Ejecutar Tarea 2
        ejecutarOperacion("Reporte de Estadísticas", calcularEstadisticas);

        // Ejecutar Tarea 3
        ejecutarOperacion("Promoción de Electrónica", aplicarDescuento);
        
    }

    // Metodo para inicializar el inventario con datos de prueba
    public static void inicializarInventario() {
        inventario.add(new Producto("Laptop Gamer", "Electrónica", 1500.00, 10, true));
        inventario.add(new Producto("Smartphone X", "Electrónica", 800.00, 25, true));
        inventario.add(new Producto("Cafetera Auto", "Hogar", 120.00, 5, false)); // No disponible
        inventario.add(new Producto("Silla Ergonómica", "Muebles", 250.00, 15, true));
        inventario.add(new Producto("Auriculares BT", "Electrónica", 50.00, 100, true));
        inventario.add(new Producto("Escritorio", "Muebles", 180.00, 8, true));
    }

    // Funcion de orden superior: Recibe un titulo y una funcion (Runnable)
    public static void ejecutarOperacion(String titulo, Runnable operacion) {
        System.out.println(">>> EJECUTANDO: " + titulo);
        operacion.run();
    }
}
