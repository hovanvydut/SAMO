/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.combinator_pattern;

import java.time.LocalDate;
import java.time.Month;
import static dut.hovanvy.combinator_pattern.CustomerRegistrationValidator.*;

/**
 *
 * @author hovanvy
 * @link https://www.youtube.com/watch?v=VRpHdSFWGPs&t=1263s
 */
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Vy",
                "hovanvydut@gmail.com",
                "+0123456789",
                LocalDate.of(2001, Month.MAY, 1)
        );
        
//        System.out.println(new CustomerValidatorService().isValid(customer));;
        
        
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);
        
        System.out.println(result);
    }
}
