/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectou;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron, Juan Esteban Peña Sanchez
 */
public class ProyectoU {
    public static void main(String[] args) {
        Aplication app = new Aplication();
        do {
            // test
            String option = JOptionPane.showInputDialog(
                "Elija la opcion:\n" + 
                "(1) 🡪 Ingresar categoria \n" + 
                "(2) 🡪 Mostrar categorias \n" + 
                "(3) 🡪 Agregar productos \n" + 
                "(4) 🡪 Ver productos de una categoria \n" + 
                "(5) 🡪 Salir \n"
            );
            switch(option){
                case "1":
                    createCategory(app);
                    break;
                case "2"://Mostrar categorias
                    ArrayList<Category> categoryList = app.categories.getCategories();
                    String categoryName = "";
                    for(Category category :categoryList){
                        categoryName+=category.name+ " \n";
                        
                    }
                    JOptionPane.showMessageDialog(null, "Las categorias disponibles son las siguientes: \n"+categoryName);
                break;
                case "3"://Agregar productos
                    Category category = app.categories.getCategory(JOptionPane.showInputDialog("Cual es el nombre de la categoria"));
                    if(category == null){
                        JOptionPane.showMessageDialog(null, "La categoria no se encontró");
                        continue;
                    }
                    category.addProduct();
                    
                break;
                case "4"://Ver productos de una categoria
                    String targetCategoryName = JOptionPane.showInputDialog("Ingrese el nombre de la categoria para ver sus productos: ");
                    ArrayList<Category> categories = app.categories.getCategories();
                    for(Category cat: categories){
                        if (targetCategoryName == cat.name){}
                        
                    }
                    
                    
                break;
                case "5": JOptionPane.showMessageDialog(null, "Saliendo del menu...");
                break;
            }
        } while(true);
    }

    public static void createCategory(Aplication app) {
        Category newCategory = app.categories.createCategory();

        JOptionPane.showMessageDialog(null, "La categoria" + newCategory.name + " ha sido creada satisfactoriamente!");
    }
}
