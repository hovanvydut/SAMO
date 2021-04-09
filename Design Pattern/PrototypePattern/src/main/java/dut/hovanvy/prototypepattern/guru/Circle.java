/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.prototypepattern.guru;

/**
 *
 * @author hovanvydut
 */
public class Circle extends Shape {
    
    public int radius;
    
    public Circle() {
        
    }
    
    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }
    
    @Override
    public Shape clone() {
        return new Circle(this);
    }
    
    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !(super.equals(object2)))
            return false;
        
        // run here ==> object2 is instance of Circle, (Shape)this.equals(object2)
        Circle shape2 = (Circle) object2;
        
        return shape2.radius == shape2.radius;
    }
}
