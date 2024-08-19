package com.mycompany.proyectou;


import javax.swing.JOptionPane;

public class Util {
    /**
     * Prompts the user for input and returns the entered value as a string.
     * 
     * @param text the text to display as the input prompt
     * @param allowNull specifies whether null input is allowed or not
     * @return the user's input as a string, or null if allowNull is false and the user cancels the input
     */
    public static String input(String text) {
        String userInput = JOptionPane.showInputDialog(null, text);
        if (userInput == null) { // user clicked cancel
            return null;
        }
        if(userInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún valor");
            return input(text);
        }
        return userInput;
    }
    /**
     * Parses the input as a float value and returns it.
     * 
     * @param text the prompt message to display for input
     * @param allowNull true if null input is allowed, false otherwise
     * @return the parsed float value
     */
    public static double inputInt(String text) {
        try {
            String usrInput = input(text);
            if (usrInput == null) {
                Util.showMessage("Cancelando...");
                return -1;
            }
            return Float.parseFloat(input(text)); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha digitado un valor invalido");
            return inputInt(text);
        }
        
    }

    // Centralized method to show a message dialog
    public static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
