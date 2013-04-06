package models;

public class Circle extends Shape
{

    Circle()
    {
    }
    //Properties of a triangle
    private double radius;

    //Getters and Setters for properties
    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    //Implementation of Shape interface method
    @Override
    public double calculateArea()
    {

        return (Double) (Math.PI * radius * radius);
    }

    @Override
    public String toString()
    {
        return "Circle (" + radius + ")";
    }
}
