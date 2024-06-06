package com.magicvet.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {

    private DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss (dd.MM.yyyy)");
    private String firstName;
    private String lastName;
    private String email;

    private List<Pet> pets = new ArrayList<>();
    private LocalDateTime registrationDateTime = LocalDateTime.now();

    @Override
    public String toString() {
            return "Client {"
                    + "\n\tfirstName = " + firstName
                    + ", lastName = " + lastName
                    + ", email = " + email
                    + ",\n\tpet = " + pets
                    + ", registrationDateTime = " + registrationDateTime.format(FORMATTER)
                    + "\n}";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pets);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPet() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }
}
