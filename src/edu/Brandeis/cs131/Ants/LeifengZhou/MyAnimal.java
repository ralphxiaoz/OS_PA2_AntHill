package edu.Brandeis.cs131.Ants.LeifengZhou;

import edu.Brandeis.cs131.Ants.AbstractAnts.Animal;
import edu.Brandeis.cs131.Ants.AbstractAnts.Anthill;
import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;

public abstract class MyAnimal extends Animal {

    public MyAnimal(String name, Colour color, int priority, int speed, int hunger) {
        super(name, color, priority, speed, hunger);
    }
}