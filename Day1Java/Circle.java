package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class Circle extends Shape {

    private double xPos;
    private double yPos;
    private double radius;

    public Circle()
    {
        this.xPos = 1;
        this.yPos = 2;
        this.radius = 3;
    }
    public Circle(int x)
    {
        this.radius = x;
    }
    public Circle(int x , int y)
    {
        this.xPos = x;
        this.yPos = y;
    }
    public Circle(int x , int y , int z)
    {
        this.xPos = x;
        this.yPos = y;
        this.radius = z;
    }

    public void fillColour()
    {
        System.out.println(this.color);
    }
    public void fillColour(int x)
    {
        super.color = x;
        System.out.println(" The circle color is now 2 ");
        System.out.println(this.color);
    }
    public void fillColour(float x)
    {
        super.saturation = x;
        System.out.println(this.saturation);
    }

    public String toString()
    {

        return ("Center = (" + this.xPos + "),"+this.yPos+")" + " and radius = " + this.radius);

    }
    public double area()
    {
        return this.radius * this.radius * 3.14;
    }


}
