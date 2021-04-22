/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.functionalprograming;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hovanvydut
 * @link https://www.youtube.com/watch?v=VRpHdSFWGPs&t=7633s
 */
public class Main {
    
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", GENDER.MALE),
                new Person("Tom", GENDER.MALE),
                new Person("Alice", GENDER.FEMALE),
                new Person("Alex", GENDER.FEMALE)
        );
        
        people.stream()
                .filter(person -> GENDER.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
    
    static class Person {
        private final String name;
        private final GENDER gender;

        public Person(String name, GENDER gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" + "name=" + name + ", gender=" + gender + '}';
        }
    }
    
    enum GENDER {
        MALE, FEMALE
    }
}
