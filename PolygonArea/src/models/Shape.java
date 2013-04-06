package models;

public abstract class Shape implements Comparable<Shape>
{

    public abstract double calculateArea();

    @Override
    public int compareTo(Shape o)
    {
        if (this.calculateArea() < o.calculateArea())
        {
            return -1;
        }
        else if (this.calculateArea() == o.calculateArea())
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
