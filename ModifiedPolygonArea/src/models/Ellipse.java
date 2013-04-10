/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azim
 */
public class Ellipse extends Shape {

    Ellipse() {
    }
    //Properties of a triangle
    private double radius1;
    private double radius2;
    private final int NO_OF_PARAMETER = 2;
    private int noOfParameters = NO_OF_PARAMETER;
    private String paramOne = "Radius1";
    private String paramTwo = "Radius2";

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (Math.PI * radius1 * radius2);
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

        this.radius1 = params.get(0);
        this.radius2 = params.get(1);
    }

    @Override
    public String toString() {
        return "Ellipse (" + radius1 + ", " + radius2 + ")";
    }
}
