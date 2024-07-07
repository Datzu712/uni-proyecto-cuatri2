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
    String name;
    String description;
    ArrayList <Product> productos = new ArrayList();
    

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void addProduct(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double price =Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        Product newProduct = new Product(name, price);
        this.productos.add(newProduct);
    }
    
    
    
}
