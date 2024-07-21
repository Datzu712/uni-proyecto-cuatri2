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
                    case "1" -> app.createCategoryOption();
                    case "2" -> app.showCategoriesOption();
                    case "3" -> app.addProductOption();
                    case "4" -> app.showProductsOption();
                    case "5" -> ended = true;
                    default -> JOptionPane.showMessageDialog(null, "Ha ingresado una opcion invalida!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error :(");
                throw e;
            }
        } while(!ended);
        JOptionPane.showMessageDialog(null, "Cerrando programa...");
    }
}
