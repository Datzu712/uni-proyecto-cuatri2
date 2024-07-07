/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

/**
 *
 * @author Aaron
 */
public class Product {
    private static int incrementalId = 0;

    public final int id;
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = Product.incrementalId++;
    }
}
