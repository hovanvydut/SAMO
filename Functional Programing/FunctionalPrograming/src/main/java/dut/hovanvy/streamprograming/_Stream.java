/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.streamprograming;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.*;

/**
 *
 * @author DELL
 */
public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", GENDER.MALE),
                new Person("Tom", GENDER.MALE),
                new Person("Alice", GENDER.FEMALE),
                new Person("Alex", GENDER.FEMALE)
        );
        
//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String::length;
//        IntConsumer println = System.out::println;
//        
//        people.stream()
//                .map(personStringFunction)
//                .mapToInt(length)
//                .forEach(println);

        boolean containOnlyFemale = people.stream()
                .allMatch(person -> GENDER.FEMALE.equals(person.gender));
        
        System.out.println(containOnlyFemale);
        
        
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
