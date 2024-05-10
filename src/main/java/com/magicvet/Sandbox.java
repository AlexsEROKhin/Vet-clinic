package com.magicvet;

import com.magicvet.comporator.DogSizeComparator;
import com.magicvet.model.Dog;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args){
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.L),
                new Dog(Dog.xxL),
                new Dog(Dog.xS)
        };
        Arrays.sort(dogs, new DogSizeComparator());
        for(Dog dog: dogs){
            System.out.println(dog.getSize());
        }
    }
}
