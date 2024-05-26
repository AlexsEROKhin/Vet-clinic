package com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{

    private Size size;

    private HealthState healthState;

    public Dog(){ }
    public Dog(Size size, HealthState healthState){
        this.size = size;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "Dog: "
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", ownerName = " + getOwnerName()
                + ", size = " + size +
                ", healthState = " + healthState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return size == dog.size && healthState == dog.healthState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, healthState);
    }

    public Size getSize() {
        return size;
    }

    public HealthState getHealthState(){
        return healthState;
    }

    public void setHealthState(HealthState healthState){
        this.healthState = healthState;
    }

    public void setSize(Size size) {
        this.size = size;
    }
    public enum HealthState{
        EXCELLENT(1),
        GOOD(2),
        FAIR(3),
        POOR(4),
        CRITICAL(5);

        private final int value;

        HealthState(int value){
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);
        private final int value;

        Size(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}

