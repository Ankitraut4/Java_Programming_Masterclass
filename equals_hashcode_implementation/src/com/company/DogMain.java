package com.company;

public class DogMain {
    public static void main(String[] args) {


        BullDog tom = new BullDog("tom");
        Dog tom2 = new Dog("tom");

        System.out.println(tom2.equals(tom));//here bullDog has instance from dog hence that is true

        System.out.println(tom.equals(tom2));//but dog does not have instance of bulldog that is false but this should not happen
        // as it voilate the rule of equal method must obey
        // so basically they must be equal so we have remove the overide method fron bullDog class(i.e subclass) ,
        // to avoid voilation of rules as the bullDog class is extent from Dog so the dog must be same
    }
}
