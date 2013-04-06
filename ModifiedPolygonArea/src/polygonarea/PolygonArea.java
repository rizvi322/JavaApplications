package polygonarea;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
                else if (shape.equalsIgnoreCase("ellipse")
                        || shape.equalsIgnoreCase("triangLe")
                        || shape.equalsIgnoreCase("rhombus"))
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
        
        mainFrame.addListKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e)
            {   
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                
                 if (e.getKeyCode() == KeyEvent.VK_DELETE) 
                 {
                     poligons.remove(mainFrame.getListSelectedIndex());
                     Iterator i = poligons.iterator();
                     poligonList = new DefaultListModel();
                     while (i.hasNext())
                     {
                         poligonList.addElement(i.next());
                     }
                     mainFrame.setPolygonList(poligonList);
                 }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
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
//        else if (shape.equalsIgnoreCase("rectangle"))
//        {
//            Rectangle rectangle = (Rectangle) factory.createInstance(shape);
//            rectangle.setWidth(paramOne);
//            rectangle.setHeight(paramTwo);
//            mainFrame.setAreaValue(rectangle.calculateArea());
//            poligons.add(rectangle);
//        }
        else if (shape.equalsIgnoreCase("square"))
        {
            Square square = (Square) factory.createInstance(shape);
            square.setLength(paramOne);
            mainFrame.setAreaValue(paramTwo);
            poligons.add(square);
        }
//        else if (shape.equalsIgnoreCase("parallelogram"))
//        {
//            Parallelogram parallelogram = (Parallelogram) factory.createInstance(shape);
//            parallelogram.setBase(paramOne);
//            parallelogram.setHeight(paramTwo);
//            mainFrame.setAreaValue(parallelogram.calculateArea());
//            poligons.add(parallelogram);
//        }
        else if (shape.equalsIgnoreCase("circle"))
        {
            Circle circle = (Circle) factory.createInstance(shape);
            circle.setRadius(paramOne);
            mainFrame.setAreaValue(circle.calculateArea());
            poligons.add(circle);
        }
        else if (shape.equalsIgnoreCase("ellipse"))
        {
            Ellipse ellipse = (Ellipse) factory.createInstance(shape);
            ellipse.setRadius1(paramOne);
            ellipse.setRadius2(paramTwo);
            mainFrame.setAreaValue(ellipse.calculateArea());
            poligons.add(ellipse);
        }
        else if (shape.equalsIgnoreCase("rhombus"))
        {
            Rhombus rhombus = (Rhombus) factory.createInstance(shape);
            rhombus.setDiagonal1(paramOne);
            rhombus.setDiagonal2(paramTwo);
            mainFrame.setAreaValue(rhombus.calculateArea());
            poligons.add(rhombus);
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
