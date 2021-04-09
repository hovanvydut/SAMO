/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.prototypepattern.pluralsight;

/**
 *
 * @author hovanvydut
 */
public class PrototypeDemo {
    
    public static void main(String[] args) {
        Registry registry = new Registry();
        
        Movie movie = (Movie) registry.createItem("Movie");
        
        System.out.println(movie);
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());
        System.out.println(movie.getPrice());
        System.out.println(movie.getRuntime());
        
        Movie anotherMovie = (Movie) registry.createItem("Movie");
//        anotherMovie.setTitle("Gang of Four");
        
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());
        System.out.println(anotherMovie.getPrice());
        System.out.println(anotherMovie.getRuntime());
    }
    
}
