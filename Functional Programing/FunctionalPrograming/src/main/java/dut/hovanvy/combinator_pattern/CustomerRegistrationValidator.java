/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.combinator_pattern;

import java.util.function.Function;
import static dut.hovanvy.combinator_pattern.CustomerRegistrationValidator.ValidationResult;
import static dut.hovanvy.combinator_pattern.CustomerRegistrationValidator.ValidationResult.*;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author hovanvydut
 */

public interface CustomerRegistrationValidator 
        extends Function<Customer, ValidationResult>{
    
//    static CustomerRegistrationValidator isEmailValid() {
//        return customer -> customer.getEmail().contains("@") ?
//                SUCCESS : EMAIL_NOT_VALID;
//    }
    
    static CustomerRegistrationValidator isEmailValid() {
        
        return new CustomerRegistrationValidator() {
            @Override
            public ValidationResult apply(Customer customer) {
                return customer.getEmail().contains("@") ?
                    SUCCESS : EMAIL_NOT_VALID;
            }   
        };
                
    }
    
    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }
    
    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS : IS_NOT_ADULT;
    }
    
    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
    
    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_ADULT
    }
}
