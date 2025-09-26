package com.dipak;

import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                case 1 -> System.out.println("Register...");
                case 2 -> System.out.println("Login...");
                case 0 -> {
                    System.out.println("Exiting Software...");
                    return;
                }
                default -> System.out.println("Enter Valid Choice...\n");
            }
        }

    }
}