package com.gmail.st1tchqwerty;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/orderdb?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "10082002Rla";
    static Connection conn;
    public static void main(String[] args) throws SQLException {
        Connection con = null;

        try {
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate(Products.createTableProducts());
            statement.executeUpdate(Clients.createTableClients());
            statement.executeUpdate(Orders.createTableOrders());

            statement.executeUpdate(Products.addProducts("phone", 5));
            statement.executeUpdate(Clients.addClients("Rostic", "2002-09-07", "0981775375"));

        } catch(SQLException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("1: add order");
            System.out.println("2: add product");
            System.out.println("3: add client");
            System.out.println("4: view orders");
            System.out.println("5: view products");
            System.out.println("6: view clients");

            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    addOrder();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    addClient();
                    break;
                case "4":
                    viewOrders();
                    break;
                case "5":
                    viewProducts();
                    break;
                case "6":
                    viewClients();
                    break;
                default:
                    return;

            }
        }
    }
    private static void addProduct() throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter count: ");
        int count = sc.nextInt();
        Statement statement = conn.createStatement();
        statement.executeUpdate(Products.addProducts(name, count));
    }

    private static void addOrder() throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter product: ");
        String product = sc.nextLine();
        Statement statement = conn.createStatement();
        statement.executeUpdate(Orders.addOrders(name, product));
    }

    private static void addClient() throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();


        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO clients (name, date, phone) VALUES(?, ?, ?)");
        try {
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, phone);

            ps.executeUpdate(); // for INSERT, UPDATE & DELETE
        } finally {
            ps.close();
        }
    }

    private static void viewOrders() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders");
        try {
            ResultSet rs = ps.executeQuery();

            try {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }

    private static void viewClients() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients");
        try {
            ResultSet rs = ps.executeQuery();

            try {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }

    private static void viewProducts() throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM products");
        try {
            ResultSet rs = ps.executeQuery();

            try {
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close();
            }
        } finally {
            ps.close();
        }
    }
}