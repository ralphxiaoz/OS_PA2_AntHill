package edu.Brandeis.cs131.Ants.LeifengZhou;

import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;

public class Armadillo extends MyAnimal {
	private final String name;
	private final Colour color;
	private int priority = 2;
	private int speed = 6;
	private int hunger = 2;
	
	public Armadillo(String name, Colour color){
		super(name, color, 2, 6, 2);
		this.name = name;
		this.color = color;
	}
	
	public String toString() {
        return String.format("%s ARMADILLO %s", this.color, this.name);
    }
	
}