package ro.teamnet.zerotohero.oop.graphicshape.Exceptii;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {
    private String nume;
    private String numeTaraOrigine;
    public AnimalZooRar()
    {

    }

    public AnimalZooRar(String nume)
    {
        this.nume = nume;
    }

    public AnimalZooRar(String nume , String nume2)
    {
        this.nume = nume;
        this.numeTaraOrigine = nume2;
    }

    public void setNume(String x)
    {
        this.nume = x;
    }
    public void setnumeTaraOrigine(String x)
    {
        this.numeTaraOrigine = x;
    }
    public String getNume()
    {
        return this.nume;
    }
    public String getNumeTaraOrigine()
    {
        return this.numeTaraOrigine;
    }
    public void faceBaie()
    {
        System.out.println(this.nume + "face baie ");
    }
    public void SeJoaca()
    {
        System.out.println(this.nume + "se joaca ");
        super.doarme();
    }
    public void mananca(Object o) throws AnimalManancaOmException
    {
        if ( o instanceof AnimalZooRar )
        {
            throw new AnimalManancaOmException();
        }
        else
        {
            System.out.println("Animalul mananca");
        }

    }


}
