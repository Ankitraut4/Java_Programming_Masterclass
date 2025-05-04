package com.company;

public class Main {

    public static void main(String[] args) {
	Animal animal=new Animal("animal",1,1,4,33);
	Dog dog=new Dog("lab",1,45,4,2,1,"brown");
	dog.eat();
      dog.run();
      dog.walk();
      dog.restatday();

		System.out.println("");
      Fish fish=new Fish("Arovana",22,66,2,2,23);
      fish.moving();
        System.out.println("");
      fish.restatNight();
      fish.restatday();
    }
}
