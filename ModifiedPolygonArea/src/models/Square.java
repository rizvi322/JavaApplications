package models;

import java.util.ArrayList;
import java.util.List;

public class Square extends Shape {

    Square() {
    }
    //Properties of a triangle
    private double length;
    private final int NO_OF_PARAMETER = 1;
    private int noOfParameters = NO_OF_PARAMETER;
    private String paramOne = "Length";

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (length * length);
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
        
        this.length = params.get(0);
    }

    @Override
    public String toString() {
        return "Square (" + length + ")";
    }
}
