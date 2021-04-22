/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.functionalprograming;

import java.util.function.*;

/**
 *
 * @author hovanvydut
 */
public class _Supplier {
    public static void main(String[] args) {
        System.out.println("connection string is " + getDBConnectionString.get());
        
    }
    
    static Supplier<String> getDBConnectionString = () -> "jdbc:mysql://localhost:3306/data";
}
