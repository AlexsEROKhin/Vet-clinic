package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

public class ApplicationRunner {
private final EntityRegister register = new EntityRegister();
    public void run() {
        if (Authenticator.auth()) {
            register.registerClients();
        }
    }
}
