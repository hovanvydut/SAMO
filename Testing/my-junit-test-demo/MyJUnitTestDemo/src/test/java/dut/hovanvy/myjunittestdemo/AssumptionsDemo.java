/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.myjunittestdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author hovanvydut
 */
public class AssumptionsDemo {
    
    private final Caculator caculator = new Caculator();
    
    @Test
    public void testOnlyOnCiServer() {
        Assumptions.assumeTrue("CI".equals(System.getenv("ENV")));
        
        System.out.println("Executed testOnlyOnCiServer");
    }
    
    @Test
    public void testInAllEnvironments() {
        Assumptions.assumingThat("CI".equals(System.getenv("ENV")), 
                () -> Assertions.assertEquals(2, this.caculator.divide(4, 2))
        );
        
        Assertions.assertEquals(42, caculator.multiply(6, 7));
    }
    
}
