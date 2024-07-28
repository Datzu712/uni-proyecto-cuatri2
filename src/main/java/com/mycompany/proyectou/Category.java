/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

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
    public ProductService products = new ProductService();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = Category.incrementalId++;
    }
    public void createProduct() {
        try {
            String name = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));

            Product newProduct = new Product(name, price);
            this.products.add(newProduct);
            JOptionPane.showMessageDialog(null, "El producto " + newProduct.name + " (" + newProduct.id + ") ha sido agregado satisfactoriamente!");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Ha ingresado un numero invalido.");
        }
    }
    public Product[] getProducts() {
        return this.products.getProducts(false);
    }
    public Product[] getProducts(boolean notNull) {
        return this.products.getProducts(notNull);
    }
    
}
