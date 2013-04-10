package models;

import java.util.List;

public abstract class Shape implements Comparable<Shape>
{
    
    public abstract double calculateArea();
    public abstract int getNoOfParameters();
    public abstract List<String> getParametersNames();
    public abstract void setParameters(List<Double> params);
    
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
