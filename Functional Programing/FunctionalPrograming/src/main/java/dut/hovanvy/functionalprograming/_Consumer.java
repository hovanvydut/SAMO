/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.functionalprograming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 *
 * @author hovanvydut
 * @link https://www.youtube.com/watch?v=VRpHdSFWGPs&t=1263s
 */
public class _Consumer {
    
    public static void main(String[] args) {
        greetCustomer.accept(new Customer("Vy", "0123123123"));
        greetCustomerV2.accept(new Customer("Vy", "0123123123"), false);
    }
    
    static Consumer<Customer> greetCustomer = 
            customer -> System.out.println("Hello " + customer.customerName 
                    + ", phone: " + customer.customerPhone);
    
    static BiConsumer<Customer, Boolean> greetCustomerV2 = 
            (customer, showPassword) -> System.out.println("Hello " + customer.customerName 
                    + ", phone: " + (showPassword ? customer.customerPhone : "******"));
    
    static class Customer {
        private final String customerName;
        private final String customerPhone;

        public Customer(String customerName, String customerPhone) {
            this.customerName = customerName;
            this.customerPhone = customerPhone;
        }
    }
}
