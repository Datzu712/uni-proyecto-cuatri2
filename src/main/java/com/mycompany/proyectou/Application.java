/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

import java.lang.foreign.Linker;

import javax.swing.JOptionPane;

/**
 *
 * @author Aaron, Juan Esteban Peña Sanchez
 */
/**
 * The `Application` class represents the main application instance.
 * It follows the Singleton design pattern to ensure that only one instance of the application is created.
 */
public class Application {
    private static Application instance;
    public CategoryService categories;

    private Application() {
        categories = new CategoryService();
    }
    /**
     * Returns the instance of the `Application` class.
     * If no instance exists, a new instance is created and returned.
     *
     * @return The instance of the `Application` class.
     */
    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    /**
     * Creates a menu to create a new category-add product
     */
    public void createCategoryProductOption(){
        String option = "";
        option = JOptionPane.showInputDialog(
            "Elija la opcion:\n" + 
            "(1) Ingresar categoria \n" + 
            "(2) Ingresar producto \n"
        );
        if(option.equals("1")){
            createCategoryOption();
        }
        else if(option.equals("2")){
            addProductOption();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ha ingresado una opcion invalida!");
        }
    }

    /**
     * Chance product price 
     */
    public void changeProductPriceOption(){
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category category = this.categories.getCategory(Util.input("Ingrese el nombre/ID de la categoria", false));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        Product product = category.products.getProduct(Util.input("Ingrese el nombre/ID del producto", false));
        if (product == null){
            JOptionPane.showMessageDialog(null, "El producto no se encontró");
            return;
        }
        double newPrice = Util.inputInt("Ingrese el nuevo precio del producto", false);
        product.price = newPrice;
        JOptionPane.showMessageDialog(null, "El precio del producto " + product.name + " ha sido cambiado a " + newPrice);
        
    }

    public void createCategoryOption() {
        Category newCategory = this.categories.createCategory();

        if (newCategory == null) {
            JOptionPane.showMessageDialog(null, "La categoria no se pudo crear");
            return;
        }

        JOptionPane.showMessageDialog(
            null, 
            "La categoria " + newCategory.name + " (" + newCategory.id + ") ha sido creada satisfactoriamente!"
        );
    }
    public void showCategoriesOption() {
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        String categoryNames = "";
        for (int i = 0; i < categories.getSize(true); i++) {
            Category category = this.categories.getCategory(""+i+"");
            categoryNames += "(" + category.id + ") " + category.name + " (" +category.getProducts(true).length+ " productos)" + "\n";
        }
        JOptionPane.showMessageDialog(null, "Las categorias disponibles son: \n" + categoryNames);
    }
    public void addProductOption() {
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category category = this.categories.getCategory(JOptionPane.showInputDialog("Ingrese el nombre/ID de la categoria"));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        category.createProduct();
    }
    public void showProductsOption() {
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category category = this.categories.getCategory(
            JOptionPane.showInputDialog("Cual es el nombre de la categoria")
        );
        if (category == null) {
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        String products = "";
        for (Product product : category.getProducts(true)) {
            products += product.name + " - " + product.price + "\n";
        }
        JOptionPane.showMessageDialog(null, "Los productos de la categoria " + category.name + " son: \n" + products);
    }
}
    public void showCompleteInventoryOption() {
        String inventoryText = "";
        for (Category category : categories.getCategories(true)) {
            inventoryText += category.name + ":\n";
            for (Product product : category.getProducts(true)) {
                inventoryText += "- " + product.name + " (Precio: " + product.price + ")\n";
            }
            inventoryText += "\n";
        }
        JOptionPane.showMessageDialog(null, inventoryText);
    }
