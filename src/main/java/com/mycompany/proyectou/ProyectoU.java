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
                "(1) Ingresar categoria \n" + 
                "(2) Mostrar categorias \n" + 
                "(3) Agregar productos \n" + 
                "(4) Ver productos de una categoria \n" + 
                "(5) Salir \n"
            );
            // Note: If the user closes the dialog, the option will be null
            if (option == null) {
                ended = true;
                break;
            }
            try {
                switch(option){
                    case "1" -> createCategoryOption(app);
                    case "2" -> showCategoriesOption(app);
                    case "3" -> addProductOption(app);
                    case "4" -> showProductsOption(app);
                    case "5" -> ended = true;
                    default -> JOptionPane.showMessageDialog(null, "Ha ingresado una opcion invalida!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error :(");
                System.out.println(e);
            }
        } while(!ended);
        JOptionPane.showMessageDialog(null, "Cerrando programa...");
    }
    public static void createCategoryOption(Application app) {
        Category newCategory = app.categories.createCategory();

        JOptionPane.showMessageDialog(
            null, 
            "La categoria" + newCategory.name + " (" + newCategory.id + ") ha sido creada satisfactoriamente!"
        );
    }
    public static void showCategoriesOption(Application app) {
        ArrayList<Category> categories = app.categories.getCategories();
        if (categories.size() == 0){
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        String categoryNames = "";
        for (Category category : categories) {
            categoryNames += "(" + category.id + ") " + category.name + "\n";
        }
        JOptionPane.showMessageDialog(null, "Las categorias disponibles son: \n" + categoryNames);
    }
    public static void addProductOption(Application app) {
        if (app.categories.getCategories().size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category category = app.categories.getCategory(JOptionPane.showInputDialog("Ingrese el nombre/ID de la categoria"));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        category.createProduct();
        /*
         * We store the original size of the products array to check if a product was added
         * bc if the size doesn't change, it means that the user didn't create a product (e.g. they closed the dialog or price is invalid)
         * so we don't need to ask if the user wants to create another product
         */
        // todo
        // int originalSize = category.getProducts().size();
        // category.createProduct();
        // if (originalSize != category.getProducts().size()) {
        //     String shouldCreateOtherProduct = JOptionPane.showInputDialog(
        //         "El producto ha sido creado satisfactoriamente para la categoria \"" + category.name +"\"!\n Desea agregar otro producto para esta misma categoria? (s/n)"
        //     );
        //     // We use ecuals method bc if we use == operator, it will compare the memory address of the strings, not the content
        //     if(shouldCreateOtherProduct.toLowerCase().equals("s")){
        //         addProductOption(app);
        //     } else {
        //         String productNames = "";
        //         for (Product product : category.getProducts()) {
        //             productNames += product.name + "\n";
        //         }
        //         JOptionPane.showMessageDialog(null, "Los productos de la categoria " + category.name + " son: \n" + productNames);
        //     }
        // }
    }
    public static void showProductsOption(Application app) {
        if (app.categories.getCategories().size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category category = app.categories.getCategory(
            JOptionPane.showInputDialog("Cual es el nombre de la categoria")
        );
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
