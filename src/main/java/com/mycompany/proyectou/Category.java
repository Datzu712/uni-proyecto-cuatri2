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
        String name = Util.input("Ingrese el nombre del producto: ");
        
        if(products.getProduct(name) != null){
            Util.showMessage("El producto ya existe.");
            return;
        }
        double price = Util.inputInt("Ingrese el precio del producto: ");
        if (Double.isNaN(price)) {
            return;
        }
        if (price < 0) {
            Util.showMessage("El precio no puede ser negativo.");
            return;
        }
        int response = JOptionPane.showConfirmDialog(null, "¿Desea agregar el producto a la categoria "+this.name+"?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.NO_OPTION) {
            Util.showMessage("El producto no ha sido agregado a la categoria "+this.name);
            return;
        }
        
        Product newProduct = new Product(name, price);
        this.products.add(newProduct);
            Util.showMessage("El producto " + newProduct.name + " (" + newProduct.id + ") ha sido agregado satisfactoriamente a la categoria "+this.name);

    }
    public Product[] getProducts() {
        return this.products.getProducts(false);
    }
    public Product[] getProducts(boolean notNull) {
        return this.products.getProducts(notNull);
    }
}
