package com.gmail.st1tchqwerty;

public class Products {
    public static String createTableProducts() {
        return "CREATE TABLE IF NOT EXISTS products ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(100),"
                + "counts INT );";
    }

    public static String addProducts(String product, int counts) {
        return "INSERT INTO products (name, counts)"
                + "VALUES ('" + product + "', " + counts + ");";
    }
}