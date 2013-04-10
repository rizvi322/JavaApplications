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
public class Rhombus extends Shape {

    Rhombus() {
    }
    //Properties of a triangle
    private double diagonal1;
    private double diagonal2;
    private final int NO_OF_PARAMETER = 2;
    private int noOfParameters = NO_OF_PARAMETER;
    private String paramOne = "Diagonal1";
    private String paramTwo = "Diagonal2";

    //Implementation of Shape interface method
    @Override
    public double calculateArea() {

        return (Double) (diagonal1 * diagonal2) / 2;
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
        
        this.diagonal1 = params.get(0);
        this.diagonal2 = params.get(1);
    }

    @Override
    public String toString() {
        return "Rhombus (" + diagonal1 + ", " + diagonal2 + ")";
    }
}
