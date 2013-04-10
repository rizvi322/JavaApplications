package models;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {

    Rectangle() {
    }
    //Properties of a triangle
    private double width;
    private double height;
    private final int NO_OF_PARAMETER = 2;
    private int noOfParameters = NO_OF_PARAMETER;
    private String paramOne = "Width";
    private String paramTwo = "Height";

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (width * height);
    }

    @Override
    public int getNoOfParameters() {
        return noOfParameters;
    }

    @Override
    public List<String> getParametersNames() {

        List<String> params = new ArrayList<String>();
        params.add(paramOne);
        params.add(paramTwo);
        return params;
    }
    
    @Override
    public void setParameters(List<Double> params) {
        
        this.width = params.get(0);
        this.height = params.get(1);
    }

    @Override
    public String toString() {
        return "Rectangle (" + width + ", " + height + ")";
    }
}
