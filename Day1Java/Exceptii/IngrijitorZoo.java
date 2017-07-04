package ro.teamnet.zerotohero.oop.graphicshape.Exceptii;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

    void lucreaza()
    {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }
    public void faceBaie()
    {
        System.out.println( "face baie ");
    }
    public void SeJoaca()
    {
        System.out.println("se joaca ");
    }

    public void lucreaza(Animal a , Object o)
    {
        System.out.println("Animal");
    }
    public void doarme()
    {
        System.out.println("Animalul doarme");
    }
    public void mananca(Object mancare) throws AnimalPeCaleDeDisparitieException
    {
        if (mancare != null  && mancare instanceof AnimalZooRar)
        {
            throw new AnimalPeCaleDeDisparitieException();
        }
        else
        {
            System.out.println("SSS");
    }
    }
    public void lucreaza(Object mancare)
    {

        this.lucreaza();
        this.faceBaie();
        this.SeJoaca();

    }

    public double calculeazabonus()
    {
        return 3 * x;
    }



}
