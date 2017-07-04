package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class RunApp {



    public static void main(String[] args)
    {

        Circles x2 = new Circles();
        System.out.println("The default circle area is "+x2.getAreaPub());
        x2.getAreaDef();

        Canvas x3 = new Canvas();
        x3.paint();
        Shape x4 = new Circle(10);
        System.out.println("The new shape object area is : " + x4.area());
        ShapeBehaviour x5 = new Square(10);
        System.out.println("The new shape object area is : " + x5.area());




        //point

        Point p1 = new Point(10,20);
        Point p2 = new Point(50,100);
        Point p3 = new Point(10,20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));



    }
}
