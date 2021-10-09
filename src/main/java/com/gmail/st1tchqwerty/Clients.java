package com.gmail.st1tchqwerty;

public class Clients {
    public static String createTableClients() {
        return "CREATE TABLE IF NOT EXISTS clients ("
                + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(50),"
                + "date DATE,"
                + "phone CHAR(10) );";
    }
    public static String addClients(String name, String date, String phone) {
        return "INSERT INTO clients (name, date, phone) "
                + "VALUES('" + name + "', \"" + date +"\", '" + phone + "' );";
    }
}
