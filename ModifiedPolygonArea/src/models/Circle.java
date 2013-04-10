package models;

import java.util.ArrayList;
import java.util.List;

public class Circle extends Shape {

    Circle() {
    }
    //Properties of a triangle
    private double radius;
    private String paramOne = "Radius";
    private final int NO_OF_PARAMETER = 1;
    private int noOfParameters = NO_OF_PARAMETER;

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (Math.PI * radius * radius);
    }

    @Override
    public int getNoOfParameters() {
        return noOfParameters;
    }

    @Override
    public List<String> getParametersNames() {

        List<String> params = new ArrayList<String>();
        params.add(paramOne);
        return params;
    }

    @Override
    public void setParameters(List<Double> params) {

        this.radius = params.get(0);
    }

    @Override
    public String toString() {
        return "Circle (" + radius + ")";
    }
}
