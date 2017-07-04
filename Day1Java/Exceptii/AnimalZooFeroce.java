package ro.teamnet.zerotohero.oop.graphicshape.Exceptii;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    @Override
    public void doarme()
    {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
    public void SeJoaca()
    {
        System.out.println("Animalul se joaca");
    }
    public void faceBaie()
    {
        System.out.println("Animalul face baie");
    }
    public void mananca(Object o) throws AnimalManancaOmException
    {

        if( o instanceof AngajatZoo )
        {
            throw new AnimalManancaOmException();
        }
        else
        {
            System.out.println("Animalul mananca");
        }

    }




}
