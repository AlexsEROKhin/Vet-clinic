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
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                registerPets(client);

                System.out.println(client);
            }
        }
    }

    private void registerPets(Client client){
        boolean continueAddPet = true;

        while(continueAddPet){
            addPet(client);

            System.out.print("Do you want to add more pets for the current client? (y/n): ");
            String answer = Main.SCANNER.nextLine();
            if("n".equals(answer)){
                continueAddPet = false;
            }
        }
    }
    private void addPet(Client client){
        System.out.print("Adding a new pet. ");

        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }
}
