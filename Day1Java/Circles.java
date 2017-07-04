package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class Circles {

    public double getAreaPub()
    {

        Circle x1 = new Circle();
        return x1.area();
    }
    public void getAreaDef()
    {
        Circle x2 = new Circle();
        System.out.println("Primul apel ");
        x2.fillColour();
        System.out.println("Al doilea apel ");
        x2.fillColour(2);
        System.out.println("Al treilea apel ");
        x2.fillColour(3.2f);
    }
}
