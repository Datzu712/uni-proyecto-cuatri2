/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectou;

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
        if (ApplicationConfig.TEST_MODE) {
            test();
        }
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
            "Elija la opción:\n" + 
            "(1) Ingresar categoría \n" + 
            "(2) Ingresar producto \n" +
            "(3) Regresar"
        );
        
        switch (option) {
            case "1":
                createCategoryOption();
                break;
            case "2":
                addProductOption();
                break;
            case "3":
                return;
            case null: // User clicked on cancel
                return;
            default: // User a non-valid option
                JOptionPane.showMessageDialog(null, "Ha ingresado una opción invalida!");
                break;
        }
    }

    /**
     * Chance product price 
     */
    public void changeProductPriceOption() {
        String inventoryText = "";
        String inventoryText2 = "";
        for (Category category : categories.getCategories(true)) {
            inventoryText += category.name + "\n"; }
            inventoryText += "\n";
            JOptionPane.showMessageDialog(null, "Categorías Disponibles:\n"+inventoryText);
        
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorías disponibles. Por favor, cree una categoría primero.");
            return;
        }
        Category category = this.categories.getCategory(Util.input("Ingrese el nombre/ID de la categoría", false));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoría no se encontró");
            return;
        }
        for (Product product : category.getProducts(true)) {
            inventoryText2 += "- " + product.name + " (Precio: " + product.price + ")\n";
        }
        inventoryText2 += "\n";
        JOptionPane.showMessageDialog(null, "Productos Disponibles\n"+inventoryText2);
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
        Category[] categoriesArray = this.categories.getCategories(true);
    
        String categoryArray="Las categorias disponibles son: \n";
        for (int i = 0; i < categoriesArray.length; i++) {
            Category category = categoriesArray[i];
            categoryArray += category.name + " con el ID (" + category.id + ") y la descripcion: " + category.description + "\n";
        }
        JOptionPane.showMessageDialog(null, categoryArray);

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
            JOptionPane.showInputDialog("Cual es el nombre/ID de la categoria")
        );
        if (category == null) {
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        if (category.getProducts(true).length == 0) {
            JOptionPane.showMessageDialog(null, "La categoria no tiene productos de momento");
            return;
        }
        String products = "";
        for (Product product : category.getProducts(true)) {
            products += product.name + " - " + product.price + "\n";
        }
        JOptionPane.showMessageDialog(null, "Los productos de la categoria " + category.name + " son: \n" + products);
    }

    public void addProductsOption() {
        if (this.categories.getSize(true) == 0) {
            JOptionPane.showMessageDialog(null, "No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }
        Category[] categoriesArray = this.categories.getCategories(true);
    
        String categoryArray="Las categorias disponibles son: \n";
        for (int i = 0; i < categoriesArray.length; i++) {
            Category category = categoriesArray[i];
            categoryArray += category.name + " con el ID (" + category.id + ") y la descripcion: " + category.description + "\n";
        }
        JOptionPane.showMessageDialog(null, categoryArray);

        Category category = this.categories.getCategory(JOptionPane.showInputDialog("Ingrese el nombre/ID de la categoria"));
        if (category == null){
            JOptionPane.showMessageDialog(null, "La categoria no se encontró");
            return;
        }
        if (category.getProducts(true).length == 0) {
            JOptionPane.showMessageDialog(null, "No existen productos en la categoria " + category.name + ". Por favor, agregue un producto primero.");
            return;
        }
        String productArray = "Los productos disponibles son: \n";
        for (int i = 0; i < category.getProducts(true).length; i++) {
            Product product = category.getProducts(true)[i];
            productArray += product.name + " con el ID (" + product.id + "), el precio: " + product.price + " y la cantidad de: "+ product.stock + "\n";
        }
        JOptionPane.showMessageDialog(null, productArray);
        Product product = category.products.getProduct(JOptionPane.showInputDialog("Ingrese el nombre/ID del producto"));
        if (product == null){
            JOptionPane.showMessageDialog(null, "El producto no se encontró");
            return;
        }
        int stock = (int)Util.inputInt("Ingrese la cantidad de productos a agregar", false);
        product.stock += stock;
        JOptionPane.showMessageDialog(null, "Se han agregado " + stock + " a la cantidad del producto " + product.name + " de la categoria " + category.name + " la cantidad total es " + product.stock);
    }

    public void showCompleteInventoryOption() {
        while (true) { 
            // 1. Mostrar lista de categorías para selección
            String categoriesText = "Seleccione una categoría o vea el inventario completo:\n";
            Category[] notNullCategories = categories.getCategories(true);
            for (int i = 0; i < notNullCategories.length; i++) {
                categoriesText += (i + 1) + ". " + notNullCategories[i].name + "\n";
            }
            categoriesText += (notNullCategories.length + 1) + ". Ver Inventario Completo\n";
            categoriesText += (notNullCategories.length + 2) + ". Regresar\n"; 
    
            int selectedOptionIndex;
            do {
                String selectedOption = JOptionPane.showInputDialog(categoriesText);
    
                // 2. Validar opción ingresada
                try {
                    selectedOptionIndex = Integer.parseInt(selectedOption) - 1;
                } catch (NumberFormatException e) {
                    selectedOptionIndex = -1; 
                }
    
                if (selectedOptionIndex < 0 || selectedOptionIndex > notNullCategories.length + 1) {
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                }
            } while (selectedOptionIndex < 0 || selectedOptionIndex > notNullCategories.length + 1);
    
            //"Regresar", salir del bucle y volver al menú principal
            if (selectedOptionIndex == notNullCategories.length + 1) {
                break; 
            }
    
            // "Ver Inventario Completo"
            if (selectedOptionIndex == notNullCategories.length) {
                String inventoryText = "";
                for (Category category : notNullCategories) {
                    inventoryText += category.name + ":\n";
                    Product[] notNullProducts = category.getProducts(true);
                    for (Product product : notNullProducts) {
                        inventoryText += "- " + product.name + " (Precio: " + product.price + ") (Cantidad: " + product.stock + ") \n";
                    }
                    inventoryText += "\n";
                }
                inventoryText += "\nPresione OK para regresar al menú principal."; 
                JOptionPane.showMessageDialog(null, inventoryText);
            } else { 
                // Mostrar productos de la categoría seleccionada
                Category selectedCategory = notNullCategories[selectedOptionIndex];
                String productsText = selectedCategory.name + ":\n";
                Product[] notNullProducts = selectedCategory.getProducts(true);
                for (Product product : notNullProducts) {
                    productsText += "- " + product.name + " (Precio: " + product.price + ") (Cantidad: " + product.stock + ")\n";
                }
    
                // Error o éxito
                if (notNullProducts.length == 0) {
                    JOptionPane.showMessageDialog(null, "La categoría seleccionada no tiene productos.");
                } else {
                    JOptionPane.showMessageDialog(null, productsText);
                }
            }
        }
    }

    private void test() {
        Category congelados = new Category("congelados", "Productos congelados");
        Category enlatados = new Category("enlatados", "Productos enlatados");

        Product helado = new Product("helado", 1000);
        Product pescado = new Product("pescado", 2000);
        Product atun = new Product("atun", 3000);

        congelados.products.add(helado);
        congelados.products.add(pescado);
        enlatados.products.add(atun);

        helado.stock = 10;
        pescado.stock = 20;
        atun.stock = 30;

        Product arroz = new Product("arroz", 4000);
        Product frijoles = new Product("frijoles", 5000);
        Product lentejas = new Product("lentejas", 6000);

        enlatados.products.add(arroz);
        enlatados.products.add(frijoles);
        enlatados.products.add(lentejas);

        arroz.stock = 40;
        frijoles.stock = 50;
        lentejas.stock = 60;

        this.categories.add(congelados);
        this.categories.add(enlatados);
    }
}

