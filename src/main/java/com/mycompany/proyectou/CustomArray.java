package com.mycompany.proyectou;

import java.lang.reflect.Array;

// (el profe no nos deja usar ArrayList)
public class CustomArray<Type> {
    public static int defaultExtraSize = 10;
    private Type[] elements;
    private Class<Type> staticType;

    public CustomArray(Class<Type> type) {
        this.staticType = type;
        elements = (Type[]) Array.newInstance(type, defaultExtraSize);
    }
    public void add(Type newElement) {
        boolean maxSizeExceeded = true;
        int nextIndex = 0;
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == null) {
                maxSizeExceeded = false;
                nextIndex = i;
                break;
            }
        }
        if (maxSizeExceeded) {
            // Siguiente indice antes de agrandar la lista (11)
            nextIndex = this.elements.length;
            this.resize(CustomArray.defaultExtraSize + this.elements.length);
        }
        this.elements[nextIndex] = (Type) newElement;
    }
    private void resize(int newSize) {
        if (newSize <= this.elements.length) {
            throw new Error("El nuevo tamaño es menor al actual");
        }
        int newLen = newSize;
        Type[] newList = (Type[]) new Object[newLen];
        // todo: change for arraycopy
        for (int i = 0; i < this.elements.length; i++) {
            newList[i] = (Type) this.elements[i];
        }
        this.elements = (Type[]) newList;
    }

    public Type[] getElements() {
        return (Type[]) this.elements;
    }
    public Type[] getElements(boolean notNull) {
        if (notNull) {
            int notNullElementsCount = this.getSize(true);

            Type[] notNullElements = (Type[]) Array.newInstance(this.staticType, notNullElementsCount);
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] != null) {
                    notNullElements[i] = this.elements[i];
                }
            }
            return notNullElements;
        } else {
            return this.elements;
        }
    }

    public Type getElement(int index) {
        return this.elements[index];
    }

    public int getSize() {
        return this.elements.length;
    }
    public int getSize(boolean notNull) {
        if (notNull) {
            int notNullElementsCount = 0;
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] != null) {
                    notNullElementsCount++;
                }
            }
            return notNullElementsCount;
        } else {
            return this.elements.length;
        }
    }
}
