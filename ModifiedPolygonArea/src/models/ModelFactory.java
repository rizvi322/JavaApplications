package models;

public class ModelFactory implements Factory {

    @Override
    public Object createInstance(String shape) {

        if (shape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } //        else if (shape.equalsIgnoreCase("rectangle"))
        //        {
        //            return new Rectangle();
        //        }
        else if (shape.equalsIgnoreCase("square")) {
            return new Square();
        } //        else if (shape.equalsIgnoreCase("parallelogram"))
        //        {
        //            return new Parallelogram();
        //        }
        else if (shape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shape.equalsIgnoreCase("ellipse")) {
            return new Ellipse();
        } else if (shape.equalsIgnoreCase("rhombus")) {
            return new Rhombus();
        }
        return null;
    }
}
