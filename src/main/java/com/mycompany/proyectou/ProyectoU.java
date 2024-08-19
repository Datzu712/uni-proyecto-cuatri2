/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectou;

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
                "Elija la opción:\n" +
                "(1) Registro\n" +
                "(2) Ingresar productos\n" +
                "(3) Editar precio de un producto\n" +
                "(4) Ver inventario\n" +
                "(5) Ver categorías existentes\n" +
                "(6) Ver productos existentes\n" +
                "(7) Salir\n"
            );
            if (option == null) {
                ended = true;
                break;
            }

            try {
                switch (option) {
                    case "1":
                        app.createCategoryProductOption();
                        break;
                    case "2":
                        app.addProductsOption();
                        break;
                    case "3":
                        app.changeProductPriceOption();
                        break;
                    case "4":
                        app.showCompleteInventoryOption();
                        break;
                    case "5":
                        app.showCategoriesOption();
                        break;
                    case "6":
                        app.showProductsOption();
                        break;
                    case "7":
                        ended = true;
                        break;
                    default:
                        Util.showMessage("Ha ingresado una opción inválida!");
                }
            } catch (Exception e) {
                Util.showMessage("Ha ocurrido un error :(");
                throw e;
            }
        } while (!ended);

        Util.showMessage("Cerrando programa...");
    }
}