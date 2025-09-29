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
            Accounts accounts = new Accounts(connection, sc);

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
                        if(email!=null){
                            System.out.println();
                            System.out.println("User Logged In!");
                            if(!accounts.account_exist(email)){
                                System.out.println();
                                System.out.println("1. Open a new Bank Account");
                                System.out.println("2. Exit");
                                if(sc.nextInt() == 1) {
                                    account_number = accounts.open_account(email);
                                    System.out.println("Account Created Successfully");
                                    System.out.println("Your Account Number is: " + account_number);
                                }else{
                                    break;
                                }

                            }
                            account_number = accounts.getAccount_number(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println();
                                System.out.println("1. Debit Money");
                                System.out.println("2. Credit Money");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. Check Balance");
                                System.out.println("5. Log Out");
                                System.out.println("Enter your choice: ");
                                choice2 = sc.nextInt();
                            }

                        }
                        else{
                            System.out.println("Incorrect Email or Password!");
                        }
                    case 3:
                        System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
                        System.out.println("Exiting System!");
                        return;
                    default:
                        System.out.println("Enter Valid Choice");
                        break;
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}