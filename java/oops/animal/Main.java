package lld.java.oops.animal;

import lld.java.oops.animal.model.Chittah;

public class Main {
    public static void main(String[] args) {
        System.out.println("Implementing Animal OOP");

        Chittah ch = new Chittah("fieary");
        ch.makeSound();
        ch.eat();
    }
}
