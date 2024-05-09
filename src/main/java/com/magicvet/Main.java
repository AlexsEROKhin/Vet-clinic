package com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "d";

    static Scanner SCANNER = new Scanner(System.in);

    private static final String NAME_PATTERN = "^[a-zA-Z-' ]{3,}$";

    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


    public static void main(String[] args) {
        run();
    }

    static void run() {
        if(auth()){
            registerNewClient();
        }
    }
    static boolean auth(){
        boolean accepted = false;
        for(int i = 0;i < 3; i++){
            System.out.print("Password:");
            String input =SCANNER.nextLine();
            if(PASSWORD.equals(input)){
                accepted = true;
                break;
            }else{
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");
        return accepted;
    }
    static void registerNewClient(){
        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        if(isEmailValid(email)){
            System.out.print("First name: ");
            String firstName = SCANNER.nextLine();
            System.out.print("Last name: ");
            String lastName = SCANNER.nextLine();
            if(isNameValid(firstName) && isNameValid(lastName)){
                Client client = buildClient(email,firstName,lastName);
                System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
            }else{
                System.out.println("Provided first name or last name is invalid");
            }

        }else{
            System.out.println("Provided email is invalid");
        }



    }

    private static boolean isNameValid(String firstName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }


    static Client buildClient(String email,String firstName,String lastName) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;


        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher =pattern.matcher(email);
        return matcher.matches();
    }
}