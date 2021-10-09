package com.gmail.st1tchqwerty;

public class Orders {
    public static String createTableOrders() {
        return "CREATE TABLE IF NOT EXISTS orders ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "clientsId INT NOT NULL,"
                + "productsId INT NOT NULL );";
    }

    public static String addOrders(String name, String product) {
        return "INSERT INTO orders SET clientsId=(SELECT id FROM clients WHERE name = '" + name
                + "'),productsId=(SELECT id FROM products WHERE name = '"+ product + "');";
    }
}