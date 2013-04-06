/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author azim
 */
public class Rhombus extends Shape
{
    
    Rhombus()
    {
    }
    //Properties of a triangle
    private double diagonal1;
    private double diagonal2;

    //Getters and Setters for properties
    public double getDiagonal1()
    {
        return diagonal1;
    }

    public void setDiagonal1(double diagonal1)
    {
        this.diagonal1 = diagonal1;
    }

    public double getDiagonal2()
    {
        return diagonal2;
    }

    public void setDiagonal2(double diagonal2)
    {
        this.diagonal2 = diagonal2;
    }

    //Implementation of Shape interface method
    @Override
    public double calculateArea()
    {

        return (Double) (diagonal1 * diagonal2) / 2;
    }

    @Override
    public String toString()
    {
        return "Rhombus (" + diagonal1 + ", " + diagonal2 + ")";
    }
}
