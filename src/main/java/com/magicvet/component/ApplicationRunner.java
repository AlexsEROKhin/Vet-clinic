package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

public class ApplicationRunner {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    public void run() {
        if(Authenticator.auth()){
            Client client = clientService.registerNewClient();

            if(client != null){
                System.out.print("Would you like to register your pet? (yes/no): ");
                String choice = Main.SCANNER.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Adding a new pet.");
                    Pet pet = petService.registerNewPet();
                    if(pet != null){
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                        System.out.println("Pet has been added.");
                    }
                }else{
                    System.out.println("Pet has not been added.");
                }
                System.out.println(client);
            }
        }
    }
}
