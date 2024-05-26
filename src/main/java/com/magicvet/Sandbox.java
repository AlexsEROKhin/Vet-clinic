package com.magicvet;

import com.magicvet.model.Dog;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args){
        Dog[] dogs = {
                new Dog(Dog.Size.M, Dog.HealthState.CRITICAL),
                new Dog(Dog.Size.S,Dog.HealthState.GOOD),
                new Dog(Dog.Size.XL,Dog.HealthState.FAIR),
                new Dog(Dog.Size.L,Dog.HealthState.CRITICAL),
                new Dog(Dog.Size.XL,Dog.HealthState.POOR),
                new Dog(Dog.Size.XS,Dog.HealthState.EXCELLENT)
        };
        // Sort by size and print
        Arrays.sort(dogs, Comparator.comparing(Dog::getSize));
        System.out.println("Sorted by size:");
        for(Dog dog: dogs){
            System.out.println(dog.getSize() + ", " + dog.getHealthState());
        }

        System.out.println();

        // Sort by health state in reverse order and print
        Arrays.sort(dogs, Comparator.comparing(Dog::getHealthState).reversed());
        System.out.println("Sorted by health state (from worst to best):");
        for(Dog dog: dogs){
            System.out.println(dog.getSize() + ", " + dog.getHealthState());
        }


    }
}
