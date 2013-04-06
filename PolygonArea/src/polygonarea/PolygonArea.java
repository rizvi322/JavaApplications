package polygonarea;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import models.*;
import views.MainFrame;
import utils.Utilities;

public class PolygonArea
{

    private MainFrame mainFrame = new MainFrame();
    private Factory factory = new ModelFactory();
    private List<Shape> poligons = new ArrayList<Shape>();
    private DefaultListModel poligonList;

    public PolygonArea()
    {

        mainFrame.setTitle("Polygon Area Calculation");
        mainFrame.setVisible(true);

        mainFrame.addCalculateActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String shape, stringOne, stringTwo;
                Double paramOne, paramTwo;
                paramOne = new Double(0);
                paramTwo = new Double(0);

                //Fetching Data from the MainFrame
                shape = mainFrame.getShapeType();
                stringOne = mainFrame.getParamOne();
                stringTwo = mainFrame.getParamTwo();
                
                if (shape.equalsIgnoreCase("circle")
                        || shape.equalsIgnoreCase("square"))
                {
                    String isConvertable = Utilities.convertable(stringOne);
                    if (isConvertable.equals("ok"))
                    {
                        paramOne = Utilities.convert(stringOne);
                        paramTwo = new Double(0);
                        calculate(shape, paramOne, paramTwo);
                    }
                    else
                    {
                        mainFrame.setParamOneError(isConvertable);
                    }
                }
                else if (shape.equalsIgnoreCase("rectangle")
                        || shape.equalsIgnoreCase("triangLe")
                        || shape.equalsIgnoreCase("parallelogram"))
                {
                    boolean one = false;
                    boolean two = false;
                    String isConvertable = Utilities.convertable(stringOne);
                    if (isConvertable.equals("ok"))
                    {
                        paramOne = Utilities.convert(stringOne);
                        one = true;
                    }
                    else
                    {
                        mainFrame.setParamOneError(isConvertable);
                    }

                    isConvertable = Utilities.convertable(stringTwo);
                    if (isConvertable.equals("ok"))
                    {
                        paramTwo = Utilities.convert(stringTwo);
                        two = true;
                    }
                    else
                    {
                        mainFrame.setParamTwoError(isConvertable);
                    }

                    if (one == true && two == true)
                    {
                        calculate(shape, paramOne, paramTwo);
                    }

                }

            }
        });
    }

    private void calculate(String shape, double paramOne, double paramTwo)
    {
        if (shape.equalsIgnoreCase("triangle"))
        {
            Triangle triangle = (Triangle) factory.createInstance(shape);
            triangle.setBase(paramOne);
            triangle.setHeight(paramTwo);
            mainFrame.setAreaValue(triangle.calculateArea());
            poligons.add(triangle);
        }
        else if (shape.equalsIgnoreCase("rectangle"))
        {
            Rectangle rectangle = (Rectangle) factory.createInstance(shape);
            rectangle.setWidth(paramOne);
            rectangle.setHeight(paramTwo);
            mainFrame.setAreaValue(rectangle.calculateArea());
            poligons.add(rectangle);
        }
        else if (shape.equalsIgnoreCase("square"))
        {
            Square square = (Square) factory.createInstance(shape);
            square.setLength(paramOne);
            mainFrame.setAreaValue(paramTwo);
            poligons.add(square);
        }
        else if (shape.equalsIgnoreCase("parallelogram"))
        {
            Parallelogram parallelogram = (Parallelogram) factory.createInstance(shape);
            parallelogram.setBase(paramOne);
            parallelogram.setHeight(paramTwo);
            mainFrame.setAreaValue(parallelogram.calculateArea());
            poligons.add(parallelogram);
        }
        else if (shape.equalsIgnoreCase("circle"))
        {
            Circle circle = (Circle) factory.createInstance(shape);
            circle.setRadius(paramOne);
            mainFrame.setAreaValue(circle.calculateArea());
            poligons.add(circle);
        }
        Collections.sort(poligons);
        Iterator i = poligons.iterator();
        poligonList = new DefaultListModel();
        while (i.hasNext())
        {
            poligonList.addElement(i.next());
        }
        mainFrame.setPolygonList(poligonList);
    }

    public static void main(String[] args)
    {
        new PolygonArea();
    }
}
