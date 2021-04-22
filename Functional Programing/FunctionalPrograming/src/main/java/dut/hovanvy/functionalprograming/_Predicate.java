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
 * @link https://www.youtube.com/watch?v=VRpHdSFWGPs&t=1263s
 */
public class _Predicate {
    public static void main(String[] args) {
        isPhoneNumberValid.and(containNumber3).test("07123123123");
    }
    
    static Predicate<String> isPhoneNumberValid = 
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    
    static Predicate<String> containNumber3 = 
            phoneNumber -> phoneNumber.contains("3");
}
