package models;

public class Triangle extends Shape
{

    Triangle()
    {
    }

    public Triangle createInstance()
    {
        return new Triangle();
    }
    //Properties of a triangle
    private double base;
    private double height;

    //Getters and Setters for properties
    public double getBase()
    {
        return base;
    }

    public void setBase(double base)
    {
        this.base = base;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    //Implementation of Shape interface method
    @Override
    public double calculateArea()
    {

        return (Double) ((base * height) / 2);
    }

    @Override
    public String toString()
    {
        return "Triangle (" + base + ", " + height + ")";
    }
}
