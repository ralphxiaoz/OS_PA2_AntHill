package edu.Brandeis.cs131.Ants.LeifengZhou;

import java.awt.Color;
import java.util.*;

import org.hamcrest.core.IsInstanceOf;

import edu.Brandeis.cs131.Ants.AbstractAnts.Animal;
import edu.Brandeis.cs131.Ants.AbstractAnts.Anthill;
import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;

/**
 *  Enforce the Anthill Restrictions described previously. 
 *	 Use the Java synchronized keyword to prevent race conditions (without introducing deadlock). 
 * */
public class BasicAnthill extends Anthill{
	
	private int numOfAardvark = 0;
	private int numOfAnteater = 0;
	private int numOfArmadillo = 0;
	private ArrayList<Colour> arrOfColour = new ArrayList<Colour>();
	
	public BasicAnthill(String name, int ants){
		super(name, ants);
	}
	
	public synchronized boolean tryToEatAt(Animal animal){
		
		if (antsLeft() <= 0) {
			return false;
		}
		
		//all animals at the same anthill at the same time must be of a different colour. 
		if (this.arrOfColour.indexOf(animal.getColour()) != -1) {
			return false;
		}

		if (animal instanceof Aardvark) {
			/*
			 * Only two aardvarks may eat at an anthill at any given time.
			 * Aardvarks will not eat at the same anthill as an anteater at the same time
			 */
			if (numOfAardvark == 2 || numOfAnteater != 0) {
				return false;
			}
			this.numOfAardvark++;
			this.arrOfColour.add(animal.getColour()); 
			this.eatAnt();
			return true;
		}
		if (animal instanceof Anteater) {
			/*
			 * Only one anteater may eat at an anthill at any given time.
			 * Anteaters will not eat at the same anthill as an aardvark at the same time.
			*/
			if (numOfAnteater == 1 || numOfAardvark != 0) {
				return false;
			}
			this.numOfAnteater++;
			this.arrOfColour.add(animal.getColour()); 
			this.eatAnt();
			return true;
		}
		if (animal instanceof Armadillo) {
			/*
			 * Armadillos will never start eating from an anthill alone.  
			 *	Armadillos will never eat from an anthill with another armadillo at the same time.  
			 *	Armadillos will eat from an anthill with an aardvark (or two aardvarks) or anteater at it.
			*/
			if ((numOfAardvark == 0 && numOfAnteater ==  0 || numOfArmadillo != 0) ) {
				return false;
			}
			this.numOfArmadillo++;
			this.arrOfColour.add(animal.getColour()); 
			this.eatAnt();
			return true;
		}
		else {
			return false;
		}
	}
	
    public synchronized void exitAnthill(Animal animal){
    	
    	if (animal instanceof Aardvark) {
    		this.numOfAardvark--;
    	}
    	if (animal instanceof Anteater) {
    		this.numOfAnteater--;
		}
		if (animal instanceof Armadillo) {
			this.numOfArmadillo--;
		}
		this.arrOfColour.remove(animal.getColour());
		
    }
	
}