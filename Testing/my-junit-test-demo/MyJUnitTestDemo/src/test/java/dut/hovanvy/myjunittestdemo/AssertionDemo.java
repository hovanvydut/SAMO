/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.myjunittestdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hovanvydut
 */

public class AssertionDemo {
    
    private final Caculator caculator = new Caculator();
    private final Person person = new Person("Jane", "Doe");
    
    @Test
    public void standardAssertions() {
        Assertions.assertEquals(2, this.caculator.add(1, 1));
        Assertions.assertEquals(4, this.caculator.multiply(2, 2), "2 * 2 should be equal 4");
        Assertions.assertTrue('a' < 'b', () -> "'a' < 'b' should be True");
    }
    
    @Test
    public void groupedAssertions() {
        Assertions.assertAll("person", () -> Assertions.assertEquals("Jane", this.person.getFirstName()),
                                        () -> Assertions.assertEquals("Doe", this.person.getLastName()));
    }
    
    @Test
    public void dependentAssertions() {
        Assertions.assertAll("properties",
                () -> {
                    String firstName = this.person.getFirstName();
                    Assertions.assertNotNull(firstName);
                    
                    Assertions.assertAll("first name",
                            () -> Assertions.assertTrue(firstName.startsWith("J")),
                            () -> Assertions.assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    String lastName = this.person.getLastName();
                    Assertions.assertNotNull(lastName);
                    
                    Assertions.assertAll("last name", 
                            () -> Assertions.assertTrue(lastName.startsWith("D")),
                            () -> Assertions.assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }
    
    @Test
    public void exceptionTesting() {
        Exception exception = Assertions.assertThrows(ArithmeticException.class, 
                () -> this.caculator.divide(1, 0));
        
        Assertions.assertEquals("/ by zero", exception.getMessage());
    }
    
}
