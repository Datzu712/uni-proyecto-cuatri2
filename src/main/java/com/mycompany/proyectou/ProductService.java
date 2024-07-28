package com.mycompany.proyectou;

public class ProductService {
    private Product[] products = new Product[ApplicationConfig.DEFAULT_ARR_SIZE];

    public void add(Product newProduct) {
        if (newProduct == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        boolean maxSizeExceeded = true;
        int nextEmptyIndex = 0;
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) {
                maxSizeExceeded = false;
                nextEmptyIndex = i;
                break;
            }
        }
        if (maxSizeExceeded) {
            nextEmptyIndex = this.products.length;
            this.resize(ApplicationConfig.DEFAULT_ARR_SIZE + this.products.length);
        }
        this.products[nextEmptyIndex] = newProduct;
    }

    private void resize(int newSize) {
        if (newSize <= this.products.length) {
            throw new IllegalArgumentException("El nuevo tamaño es menor al actual");
        }

        Product[] newList = new Product[newSize];
        for (int i = 0; i < this.products.length; i++) {
            newList[i] = this.products[i];
        }
        this.products = newList;
    }
    public Product[] getProducts() {
        return this.products;
    }
    public Product[] getProducts(Boolean notNull) {
        if (notNull) {
            int notNullElementsCount = 0;
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i] != null) {
                    notNullElementsCount++;
                }
            }
            Product[] notNullElements = new Product[notNullElementsCount];
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i] != null) {
                    notNullElements[i] = this.products[i];
                }
            }
            return notNullElements;
        }
        return this.products;
    }

    public int getSize(Boolean notNull) {
        if (notNull) {
            int notNullElementsCount = 0;
            for (int i = 0; i < this.products.length; i++) {
                if (this.products[i] != null) {
                    notNullElementsCount++;
                }
            }
            return notNullElementsCount;
        }
        return this.products.length;
    }

    public Product getProduct(String productName) {
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) continue;

            if (this.products[i].name.equals(productName)) {
                return this.products[i];
            } else if (String.valueOf(this.products[i].id).equals(productName)) {
                // String.valueOf() converts the integer to a string
                return this.products[i];
            }
        }
        return null;
    }
}
