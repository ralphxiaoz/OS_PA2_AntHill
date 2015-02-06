package edu.Brandeis.cs131.Ants.LeifengZhou;

import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;

public class Aardvark extends MyAnimal {
	private final String name;
	private final Colour color;
	private final int priority = 1;
	private final int speed = 8;
	private final int hunger = 3;
	
	public Aardvark(String name, Colour color){
		super(name, color, 1, 8, 3);
		this.name = name;
		this.color = color;
	}
	
	public String toString() {
        return String.format("%s AARDVARK %s", this.color, this.name);
    }
	
}