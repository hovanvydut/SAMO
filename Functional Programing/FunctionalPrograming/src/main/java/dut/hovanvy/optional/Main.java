/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.optional;

import java.util.Optional;

/**
 *
 * @author hovanvydut
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Vy", null);
        
        String email = person.getEmail()
                .map(String::toLowerCase)
                .orElse("email is not provided");
        
        System.out.println(email);
    }
}

class Person {
    private final String name;
    private final String email;
    
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}
