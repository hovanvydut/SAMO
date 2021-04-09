/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.prototypepattern.guru;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public abstract class Shape {
    
    public int x;
    public int y;
    public String color;
    
    public Shape() {
        
    }
    
    public Shape(Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }
    
    public abstract Shape clone();

    @Override
    public boolean equals(Object obj) {
        
        if (!(obj instanceof Shape))
            return false;
        
        Shape shape2 = (Shape) obj;
        return (shape2.x == this.x) && (shape2.y == this.y) && 
                (Objects.equals(shape2.color, this.color));
    }
    
}
