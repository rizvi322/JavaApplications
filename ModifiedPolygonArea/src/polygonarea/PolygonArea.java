package polygonarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import models.*;
import utils.Utilities;
import views.MainFrame;

public class PolygonArea {

    private MainFrame mainFrame = new MainFrame();
    private Factory factory = new ModelFactory();
    private List<Shape> polygons = new ArrayList<Shape>();
    private DefaultListModel polygonList;

    public PolygonArea() {

        mainFrame.setTitle("Polygon Area Calculation");
        mainFrame.setVisible(true);

        //Setting ShapeType Combo Box action listener
        mainFrame.addShapeTypeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String shapeName = mainFrame.getShapeType();
                getShapeFormView(shapeName);
            }
        });

        //Setting Calculate Button action listener
        mainFrame.addCalculateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String shapeName, stringOne, stringTwo;
                boolean one = true;
                boolean two = true;
                shapeName = mainFrame.getShapeType();

                //Creating the Shape object and params list
                Shape shape = (Shape) factory.createInstance(shapeName);
                List<Double> params = new ArrayList<Double>();

                //Checking whether paramOne is convertable or not
                stringOne = mainFrame.getParamOne();
                String isConvertable = Utilities.convertable(stringOne);
                if (isConvertable.equals("ok")) {

                    //Converting paramOne and adding into params list
                    double paramOne = Utilities.convert(stringOne);
                    params.add(paramOne);
                } else {

                    one = false;
                    mainFrame.setParamOneError(isConvertable);
                }
                if (shape.getNoOfParameters() == 2) {

                    //Checking whether paramOne is convertable or not
                    stringTwo = mainFrame.getParamTwo();
                    isConvertable = Utilities.convertable(stringTwo);
                    if (isConvertable.equals("ok")) {

                        //Converting paramOne and adding into params list
                        double paramTwo = Utilities.convert(stringTwo);
                        params.add(paramTwo);
                    } else {

                        two = false;
                        mainFrame.setParamTwoError(isConvertable);
                    }
                }

                if (one == two == true) {
                    //Calculating and Setting areaValue
                    shape.setParameters(params);
                    double areaValue = shape.calculateArea();
                    mainFrame.setAreaValue(Double.toString(areaValue));

                    //Setting Shape into the list
                    polygons.add(shape);
                    Collections.sort(polygons);
                    Iterator i = polygons.iterator();
                    polygonList = new DefaultListModel();
                    while (i.hasNext()) {
                        polygonList.addElement(i.next());
                    }
                    mainFrame.setPolygonList(polygonList);
                }
            }
        });

        //Setting Polygon List Key press action listener 
        mainFrame.addListKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    polygons.remove(mainFrame.getListSelectedIndex());
                    Iterator i = polygons.iterator();
                    polygonList = new DefaultListModel();
                    while (i.hasNext()) {
                        polygonList.addElement(i.next());
                    }
                    mainFrame.setPolygonList(polygonList);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    // Defining The Mainframe Form view For Different Select Types
    private void getShapeFormView(String shapeName) {

        if (shapeName.equalsIgnoreCase("select")) {
            mainFrame.setFormVisibility(false);
        } else {
            Shape shape = (Shape) factory.createInstance(shapeName);
            List<String> params = shape.getParametersNames();

            mainFrame.setAreaValue("");
            mainFrame.setParamOneError("");
            mainFrame.setParamTwoError("");
            mainFrame.setParamOne("");
            mainFrame.setParamTwo("");

            if (shape.getNoOfParameters() == 2) {
                mainFrame.setFormVisibility(false);
                mainFrame.setParamOneLabel(params.get(0));
                mainFrame.setParamTwoLabel(params.get(1));
                mainFrame.setParamOneFieldVisibility(true);
                mainFrame.setParamTwoFieldVisibility(true);
                mainFrame.setFormVisibility(true);
            } else {
                mainFrame.setFormVisibility(false);
                mainFrame.setParamOneLabel(params.get(0));
                mainFrame.setParamTwoLabel("");
                mainFrame.setParamOneFieldVisibility(true);
                mainFrame.setParamTwoFieldVisibility(false);
                mainFrame.setFormVisibility(true);
            }
        }
    }

    public static void main(String[] args) {
        new PolygonArea();
    }
}
