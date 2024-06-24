package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientService {
    private static final String NAME_PATTERN = "^[a-zA-Z-' ]{3,}$";

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Optional<Client> registerNewClient(){
        Client client = null;
        System.out.println("Please provide a client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if(isEmailValid(email)){
            System.out.print("First name: ");
            String firstName = Main.SCANNER.nextLine();
            System.out.print("Last name: ");
            String lastName = Main.SCANNER.nextLine();
            if(isNameValid(firstName) && isNameValid(lastName)){
                client = buildClient(email,firstName,lastName);
                System.out.println("New client: "
                        + client.getFirstName()
                        + " " + client.getLastName()
                        + " (" + client.getEmail() + ")");
            }else{
                System.out.println("Provided first name or last name is invalid");
            }

        }else{
            System.out.println("Provided email is invalid");
        }


return Optional.ofNullable(client);
    }
    private static boolean isNameValid(String firstName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    private static Client buildClient(String email,String firstName,String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        System.out.print("Location: ");
        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Client.Location.valueOf(locationInput);
        }catch (IllegalArgumentException e){
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

        return client;
    }
    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher =pattern.matcher(email);
        return matcher.matches();
    }
}
