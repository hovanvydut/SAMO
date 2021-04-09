/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.mymockitodemo;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import static org.mockito.Mockito.*;

/**
 *
 * @author DELL
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MockitoDemoTest {
    
    public MockitoDemoTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    @Order(1)
    @DisplayName("Test some method")
    public void testSomeMethod() {
        List mockedList = mock(List.class);
        
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());
        
        System.out.println(mockedList.get(0));
//        System.out.println(mockedList.get(1));
        
        System.out.println(mockedList.get(999));
        verify(mockedList).get(0);
        
        System.out.println("==================");
    }
    
    @Test
    @Order(2)
    @DisplayName("Test Verify method")
    public void testVerifyMethod() {
        List<String> mockedList = mock(List.class);
        
        mockedList.size();
        mockedList.size();
        
        verify(mockedList, times(2)).size();
        System.out.println("verify size() is call two times");
        
        verify(mockedList, never()).clear();
        System.out.println("Verify clear() hasn't called before");
        
        mockedList.add("mystring");
        verify(mockedList).add("mystring");
        
        System.out.println("==================");
    }
    
}
