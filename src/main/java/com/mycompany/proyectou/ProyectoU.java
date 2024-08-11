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
                "(1) Ver Inventario Completo\n" +
                "(2) Registrar categoría o registrar productos a una categoría\n" +
                "(3) Mostrar categorías\n" +
                "(4) Ver productos de una categoría\n" +
                "(5) Cambiar precio a un producto\n" +
                "(6) Salir\n"
            );

            if (option == null) {
                ended = true;
                break;
            }

            try {
                switch (option) {
                    case "1":
                        app.showCompleteInventoryOption();
                        break;
                    case "2":
                        app.createCategoryProductOption();
                        break;
                    case "3":
                        app.showCategoriesOption();
                        break;
                    case "4":
                        app.showProductsOption();
                        break;
                    case "5":
                        app.changeProductPriceOption();
                        break;
                    case "6":
                        ended = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ha ingresado una opción inválida!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error :(");
                throw e;
            }
        } while (!ended);

        JOptionPane.showMessageDialog(null, "Cerrando programa...");
    }
}