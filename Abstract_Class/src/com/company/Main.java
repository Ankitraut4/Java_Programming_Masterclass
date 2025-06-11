package com.company;

public class Main {

    public static void main(String[] args) {
	Dog dog=new Dog("germanShefhert");
	dog.eat();
	dog.breath();
		System.out.println("");
	Parrot parrot=new Parrot("parrot");
	parrot.eat();
	parrot.breath();
	parrot.canTalk();
	parrot.fly();
		System.out.println("");
		Penguin penguin=new Penguin("penguin");
		penguin.eat();
		penguin.breath();
		penguin.canTalk();
		penguin.fly();
    }
}
