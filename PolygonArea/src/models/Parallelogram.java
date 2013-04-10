package models;

import java.util.ArrayList;
import java.util.List;

public class Parallelogram extends Shape {

    Parallelogram() {
    }
    //Properties of a triangle
    private double base;
    private double height;
    private final int NO_OF_PARAMETER = 2;
    private int noOfParameters = NO_OF_PARAMETER;
    private String paramOne = "Base";
    private String paramTwo = "Height";

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (base * height);
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
        
        this.base = params.get(0);
        this.height = params.get(1);
    }

    @Override
    public String toString() {
        return "Parallelogram (" + base + ", " + height + ")";
    }
}
