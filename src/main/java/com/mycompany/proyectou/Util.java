package com.mycompany.proyectou;

import java.util.function.Function;

import javax.swing.JOptionPane;

public class Util {
    public static String Mapear(Object[] list, Function<Object, Object> fn) {
        String text = "";
        for (int i = 0; i < list.length; i++) {
            text += fn.apply(list[i]);
        }
        return text;
    }

    public static String input(String text, boolean allowNull){
        if(!allowNull){
            String userInput = JOptionPane.showInputDialog(null, text);
            if(userInput == null || userInput.isEmpty()){
                JOptionPane.showMessageDialog(null, "Digite un valor valido");
                return input(text, allowNull);
            }
            return userInput;
        }
        return JOptionPane.showInputDialog(null, text);    
    }
    public static float inputInt(String text, boolean allowNull){
        try {
            return Float.parseFloat(input(text, allowNull)); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha digitado un valor invalido");
            return inputInt(text, allowNull);
        }
        
    }
}
