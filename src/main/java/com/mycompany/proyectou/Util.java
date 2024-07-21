package com.mycompany.proyectou;

import java.util.function.Function;

public class Util {
    public static String Mapear(Object[] list, Function<Object, Object> fn) {
        String text = "";
        for (int i = 0; i < list.length; i++) {
            text += fn.apply(list[i]);
        }
        return text;
    }
}
