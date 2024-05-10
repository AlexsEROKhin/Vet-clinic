package com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    public static final String xS = "xS";
    public static final String S = "S";
    public static final String M = "M";
    public static final String L = "L";
    public static final String xxL = "xxL";
    private String size;

    public Dog(){ }
    public Dog(String size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "Dog: "
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", ownerName = " + getOwnerName()
                + ", size = " + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
