package com.dipak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
    private static final String url = "jdbc:mysql://localhost:3306/bankingapp";
    private static final String username = "root";
    private static final String password = "2004";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);
            User user = new User(connection, sc);

            String email;
            long account_number;

            while (true) {
                System.out.println("+---------------------------------+\n" +
                        "|    Banking Management System    |\n" +
                        "+---------------------------------+");
                System.out.println("1) Register \n" +
                        "2) Login \n" +
                        "0) Exit \n");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        user.register();
                    case 2:
                        email = user.login();
                    case 0:
                        System.out.println("Exiting Software...");
                        return;
                    default:
                        System.out.println("Enter Valid Choice...\n");
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}