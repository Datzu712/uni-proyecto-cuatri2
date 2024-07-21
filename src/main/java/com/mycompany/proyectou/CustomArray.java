package com.mycompany.proyectou;

public class CustomArray<T extends Object> {
    public static int defaultExtraSize = 10;
    private T[] elements;

    public CustomArray() {
        elements = (T[]) new Object[10];
    }
    public void add(T newElement) {
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
        this.elements[nextIndex] = newElement;
    }
    private void resize(int newSize) {
        if (newSize <= this.elements.length) {
            throw new Error("El nuevo tamaño es menor al actual");
        }
        int newLen = newSize;
        T[] newList = (T[]) new Object[newLen];
        for (int i = 0; i < this.elements.length; i++) {
            newList[i] = (T) this.elements[i];
        }
        this.elements = newList;
    }

    public T[] getElements() {
        return this.elements;
    }

    public T getElement(int index) {
        return this.elements[index];
    }
}
