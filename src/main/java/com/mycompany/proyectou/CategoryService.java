/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

import javax.swing.JOptionPane;

/**
 * The CategoryService class represents a service for managing categories.
 * @author Aaron, Juan Esteban Peña Sanchez
 */
public class CategoryService {
    private CustomArray<Category> categories = new CustomArray<Category>();
    
    /**
     * Creates a new category based on user input.
     * @return The newly created category.
     */
    public Category createCategory() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre de la categoria: ");
        String description =JOptionPane.showInputDialog("Ingrese la descripcion de la categoria: ");

        Category newCategory = new Category(name, description);
        this.categories.add(newCategory);

        return newCategory;
    }
    
    /**
     * Returns all categories.
     * @return A list of all categories inside this instance.
     */
    public Category[] getCategories(){
        return this.categories.getElements();
    }
    /**
     * Returns a category by its name.
     * @param categoryName The name of the category to retrieve.
     * @return The category with the specified name, or null if not found.
     */
    public Category getCategory(String categoryQuery) {
        for (int i = 0; i < this.categories.getElements().length; i++) {
            Category category = this.categories.getElement(i);
            if (category == null) continue;

            if (category.name.equals(categoryQuery)){
                return category;
            }
            String categoryId = Integer.toString(category.id);
            if (categoryId.equals(categoryQuery)){
                return category;
            }
        }
        return null;
    }
}
