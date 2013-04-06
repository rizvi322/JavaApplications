/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author azim
 */
public class Ellipse extends Shape
{
    
    Ellipse()
    {
    }
    //Properties of a triangle
    private double radius1;
    private double radius2;

    //Getters and Setters for properties
    public double getRadius1()
    {
        return radius1;
    }

    public void setRadius1(double radius1)
    {
        this.radius1 = radius1;
    }

    public double getRadius2()
    {
        return radius2;
    }

    public void setRadius2(double radius2)
    {
        this.radius2 = radius2;
    }

    //Implementation of Shape interface method
    @Override
    public double calculateArea()
    {

        return (Double) (Math.PI * radius1 * radius2);
    }

    @Override
    public String toString()
    {
        return "Ellipse (" + radius1 + ", " + radius2 + ")";
    }
}
