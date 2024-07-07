/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aaron,  Juan Esteban Peña Sanchez
 */
public class CategoryService {
    private ArrayList <Category> categories = new ArrayList<Category>();
    
    public Category createCategory(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre de la categoria: ");
        String description =JOptionPane.showInputDialog("Ingrese la descripcion de la categoria: ");

        Category newCategory = new Category(name, description);
        this.categories.add(newCategory);

        return newCategory;
    }
    public ArrayList<Category> getCategories(){
        return this.categories;
        
    }
    public Category getCategory(String categoryName){
        Category targetCategory = null;
        for(Category category:this.categories){
            if(category.name == categoryName){
                targetCategory = category;
            }
            
        }
        return targetCategory;
    }
    
}
