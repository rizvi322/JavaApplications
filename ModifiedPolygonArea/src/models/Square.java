package models;

public class Square extends Shape
{

    Square()
    {
    }
    //Properties of a triangle
    private double length;

    //Getters and Setters for properties
    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    //Implementation of Shape interface method
    @Override
    public double calculateArea()
    {

        return (Double) (length * length);
    }

    @Override
    public String toString()
    {
        return "Square (" + length + ")";
    }
}
