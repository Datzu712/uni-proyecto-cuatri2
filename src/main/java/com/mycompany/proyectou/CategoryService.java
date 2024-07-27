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
    private Category[] categories = new Category[ApplicationConfig.DEFAULT_ARR_SIZE];

    /**
     * Adds a new category to the current instance.
     *
     * @param newCategory the category to be added in the current instance.
     * @throws IllegalArgumentException if the newCategory is null
     */
    public void add(Category newCategory) {
        if (newCategory == null) {
            /* 
                If newCategory is null, throw an IllegalArgumentException with a descriptive message
                This ensures that the method does not proceed with a null value, which could cause
                unexpected behavior or errors later in the code.
            */throw new IllegalArgumentException("La categoria no puede ser nula");
        }
        // variable to check if the array is full
        boolean maxSizeExceeded = true;
        /*  
            variable to store the next empty index in the array where the new category will be added
            Ej: [Category1, Category2, null, null] -> nextEmptyIndex = 2
                    0         1         2     3
        */
        int nextEmptyIndex = 0;
        for (int i = 0; i < this.categories.length; i++) {
            if (this.categories[i] == null) {
                maxSizeExceeded = false;
                nextEmptyIndex = i;
                break;
            }
        }
        if (maxSizeExceeded) {
            nextEmptyIndex = this.categories.length;
            this.resize(ApplicationConfig.DEFAULT_ARR_SIZE + this.categories.length);
        }
        this.categories[nextEmptyIndex] = newCategory;
    }

    private void resize(int newSize) {
        if (newSize <= this.categories.length) {
            throw new IllegalArgumentException("El nuevo tamaño es menor al actual");
        }

        Category[] newList = new Category[newSize];
        for (int i = 0; i < this.categories.length; i++) {
            newList[i] = this.categories[i];
        }
        this.categories = newList;
    }
    /**
     * Creates a new category based on user input.
     * @return The newly created category.
     */
    public Category createCategory() {
        String name = JOptionPane.showInputDialog("Ingrese el nombre de la categoria: ");
        String description =JOptionPane.showInputDialog("Ingrese la descripcion de la categoria: ");

        Category newCategory = new Category(name, description);
        this.add(newCategory);

        return newCategory;
    }
    /**
     * Returns all categories.
     * @return A list of all categories inside this instance.
     */
    public Category[] getCategories() {
        return this.categories;
    }
    /**
     * Returns all defined categories (remove all null values from <CategoryService/>.categories list).
     */
    public Category[] getCategories(boolean notNull) {
        if (notNull) {
            int notNullElementsCount = this.getSize(true);
            Category[] notNullElements = new Category[notNullElementsCount];
            for (int i = 0; i < this.categories.length; i++) {
                if (this.categories[i] != null) {
                    notNullElements[i] = this.categories[i];
                }
            }
            return notNullElements;
        } else {
            return this.categories;
        }
    }
    /**
     * Returns a category by its name or ID.
     * @param categoryName The name of the category to retrieve.
     * @return The category with the specified name, or null if not found.
     */
    public Category getCategory(String categoryName) {
        for (int i = 0; i < this.categories.length; i++) {
            if (this.categories[i] == null) continue;

            if (this.categories[i].name.equals(categoryName)) {
                return this.categories[i];
            } else if (String.valueOf(this.categories[i].id).equals(categoryName)) {
                // String.valueOf() converts the integer to a string
                return this.categories[i];
            }
        }
        return null;
    }
    public int getSize(boolean notNull) {
        if (notNull) {
            int notNullElementsCount = 0;
            for (int i = 0; i < this.categories.length; i++) {
                if (this.categories[i] != null) {
                    notNullElementsCount++;
                }
            }
            return notNullElementsCount;
        }
        return this.categories.length;
    }
}
