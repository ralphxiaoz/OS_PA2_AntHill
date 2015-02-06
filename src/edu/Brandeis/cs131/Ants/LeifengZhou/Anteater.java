package edu.Brandeis.cs131.Ants.LeifengZhou;

import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;

public class Anteater extends MyAnimal {
	private final String name;
	private final Colour color;
	private int priority = 2;
	private int speed = 4;
	private int hunger = 3;
	
	public Anteater(String name, Colour color){
		super(name, color, 2, 4, 3);
		this.name = name;
		this.color = color;
	}
	
	public String toString() {
        return String.format("%s ANTEATER %s", this.color, this.name);
    }
}