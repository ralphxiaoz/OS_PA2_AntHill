package edu.Brandeis.cs131.Ants.LeifengZhou;

import edu.Brandeis.cs131.Ants.AbstractAnts.Animal;
import edu.Brandeis.cs131.Ants.AbstractAnts.AntFactory;
import edu.Brandeis.cs131.Ants.AbstractAnts.Anthill;
import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;
import edu.Brandeis.cs131.Ants.AbstractAnts.Log.AntLog;
import java.util.Collection;

public class ConcreteAntFactory implements AntFactory {

    @Override
    public Anthill createNewBasicAnthill(String label, int numAnts) {
        BasicAnthill basicAnthill = new BasicAnthill(label, numAnts);
        return basicAnthill;
    }

    @Override
    public Animal createNewAardvark(String label, Colour color) {
        Aardvark aardvark = new Aardvark(label, color);
        return aardvark;
    }

    @Override
    public Animal createNewAnteater(String label, Colour color) {
    	Anteater anteater = new Anteater(label, color);
        return anteater;
    }

    @Override
    public Animal createNewArmadillo(String label, Colour color) {
    	Armadillo armadillo = new Armadillo(label, color);
        return armadillo;
    }

    @Override
    public Animal createNewExterminator(String label, Colour color) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Anthill createNewScheduledAnthill(String label, Collection<Anthill> basicAnthills, AntLog log) {
       ScheduledAnthill scheduledAnthill = new ScheduledAnthill(label, basicAnthills, log);
       return scheduledAnthill;
    }

    @Override
    public Anthill createNewPreemptiveAnthill(String label, Collection<Anthill> basicAnthills) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
