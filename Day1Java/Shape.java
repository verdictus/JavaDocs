package ro.teamnet.zerotohero.oop.graphicshape;



/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class Shape extends AbstractShape implements ShapeBehaviour  {

    protected int color;
    protected float saturation;


    public void setColor(int color)
    {
        this.color = color;
    }
    public void setSaturation(float saturation)
    {
        this.saturation = saturation;
    }
    public float getSaturation()
    {
        return this.saturation;
    }

    public double area()
    {

       return this.saturation;

    }

}
