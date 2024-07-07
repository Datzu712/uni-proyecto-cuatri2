/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron
 */
public class Category {
    static private int incrementalId = 0;

    public final int id;
    public String name;
    public String description;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = Category.incrementalId++;
    }
    public void createProduct(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double price =Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        Product newProduct = new Product(name, price);
        this.products.add(newProduct);
    }
    public ArrayList<Product> getProducts(){
        return this.products;
    }
}
