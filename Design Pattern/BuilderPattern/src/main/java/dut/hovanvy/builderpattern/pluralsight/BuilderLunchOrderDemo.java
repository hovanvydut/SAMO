/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.builderpattern.pluralsight;

/**
 *
 * @author hovanvydut
 */
public class BuilderLunchOrderDemo {
    
    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();
        
        builder.bread("Wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey");
        
        LunchOrder lunchOrder = builder.build();
        
        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
    
}
