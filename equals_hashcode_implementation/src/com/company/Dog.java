package com.company;

public class Dog {
    //example of how to avoid overide the method if the intial class is not final i.e HeavenlyBody

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Dog) {

            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
