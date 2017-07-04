package ro.teamnet.zerotohero.oop.graphicshape.Exceptii;

/**
 * Created by madalin.mocanu on 7/4/2017.
 */
public interface AngajatZoo {
    Integer x = 50;

    void lucreaza (Object animal);
    abstract void mananca(Object x) throws AnimalPeCaleDeDisparitieException , AnimalManancaAnimalException , AnimalManancaOmException;
    abstract void SeJoaca();
    abstract void faceBaie();
    void doarme();
    double calculeazabonus();
}
