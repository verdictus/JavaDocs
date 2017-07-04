package ro.teamnet.zerotohero.oop.graphicshape.Exceptii;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    public void lucreaza(Object o)
    {
        if(o instanceof AnimalZooFeroce)
        {
            faceBaie();
        }
        else
        {
            System.out.println("Veterinarul are grija de animal");
        }
    }
    public void SeJoaca()
    {
        System.out.println("A");
    }
    public void lucreaza(Animal a)
    {
        System.out.println("SSS");
    }
    public void faceBaie()
    {
        System.out.println("Animalul face baie");
    }
    public void mananca(Object o) throws AnimalManancaAnimalException
    {
        System.out.println("Animalul mananca");

        if ( o instanceof Animal)
        {
            throw new AnimalManancaAnimalException();
        }
        else
        {
            System.out.println("Totul e ok");
        }
    }
    public void doarme()
    {
        System.out.println("Animalul doarme");
    }
    public double calculeazabonus()
    {
        return 2 * x;
    }


}
