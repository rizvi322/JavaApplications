package models;

public class Rectangle extends Shape
{

    Rectangle()
    {
    }
    //Properties of a triangle
    private double width;
    private double height;

    //Getters and Setters for properties
    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
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

        return (Double) (width * height);
    }

    @Override
    public String toString()
    {
        return "Rectangle (" + width + ", " + height + ")";
    }
}
