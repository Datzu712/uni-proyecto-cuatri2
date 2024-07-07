/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectou;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Aaron, Juan Esteban Peña Sanchez
 * Source code: https://github.com/Datzu712/uni-proyecto-cuatri2
 */
public class ProyectoU {
    public static void main(String[] args) {
        Application app = Application.getInstance();
        Boolean ended = false;
        do {
            String option = JOptionPane.showInputDialog(
                "Elija la opcion:\n" + 
                "(1) 🡪 Ingresar categoria \n" + 
                "(2) 🡪 Mostrar categorias \n" + 
                "(3) 🡪 Agregar productos \n" + 
                "(4) 🡪 Ver productos de una categoria \n" + 
                "(5) 🡪 Salir \n"
            );
            switch(option){
                case "1" -> createCategoryOption(app);
                case "2" -> showCategoriesOption(app);
                case "3" -> addProductOption(app);
                case "4" -> showProductsOption(app);
                case "5" -> ended = true;
                default -> JOptionPane.showMessageDialog(null, "Ha ingresado una opcion invalida!");
            }
        } while(!ended);
        JOptionPane.showMessageDialog(null, "Cerrando programa!");
    }
    public static void createCategoryOption(Application app) {
        Category newCategory = app.categories.createCategory();

        JOptionPane.showMessageDialog(null, "La categoria" + newCategory.name + " ha sido creada satisfactoriamente!");
    }
    public static void showCategoriesOption(Application app) {
        ArrayList<Category> categories = app.categories.getCategories();
        String categoryNames = "";
        for (Category category : categories) {
            categoryNames += category.name + "\n";
        }
        JOptionPane.showMessageDialog(null, "Las categorias disponibles son: \n" + categoryNames);
    }

    public static void addProductOption(Application app) {
        Category category = app.categories.getCategory(JOptionPane.showInputDialog("Cual es el nombre de la categoria"));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        category.createProduct();
        String shouldCreateOtherProduct = JOptionPane.showInputDialog(
            "El producto ha sido creado satisfactoriamente para la categoria \"" + category.name +"\"! Desea agregar otro producto para esta misma categoria? (s/n)"
        );
        // We use ecuals method bc if we use == operator, it will compare the memory address of the strings, not the content
        if(shouldCreateOtherProduct.toLowerCase().equals("s")){
            addProductOption(app);
        } else {
            String productNames = "";
            for (Product product : category.getProducts()) {
                productNames += product.name + "\n";
            }
            JOptionPane.showMessageDialog(null, "Los productos de la categoria " + category.name + " son: \n" + productNames);
        }
    }
    public static void showProductsOption(Application app) {
        Category category = app.categories.getCategory(JOptionPane.showInputDialog("Cual es el nombre de la categoria"));
        if(category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        String products = "";
        for (Product product : category.getProducts()) {
            products += product.name + " - " + product.price + "\n";
        }
        JOptionPane.showMessageDialog(null, "Los productos de la categoria " + category.name + " son: \n" + products);
    }
}
