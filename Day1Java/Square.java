package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class Square extends Shape {

    private int side;
    public Square(int x)
    {
        this.side = x;
    }
    public double area()
    {
        return this.side * this.side;
    }


}
