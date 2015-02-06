package edu.Brandeis.cs131.Ants.LeifengZhou;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import edu.Brandeis.cs131.Ants.AbstractAnts.Animal;
import edu.Brandeis.cs131.Ants.AbstractAnts.Anthill;
import edu.Brandeis.cs131.Ants.AbstractAnts.Colour;
import edu.Brandeis.cs131.Ants.AbstractAnts.Log.AntLog;

public class ScheduledAnthill extends Anthill{
	
	private Collection<Anthill> basicAnthills;
	private ArrayList<Integer> arrOfWaiting = new ArrayList<Integer>();
	private HashMap<Animal, Anthill> anthillOfAnimal = new HashMap<Animal, Anthill>();
	private ArrayList<Colour> arrOfColour = new ArrayList<Colour>();
	
	public ScheduledAnthill(String name, Collection<Anthill> basicAnthills, AntLog log){
		super(name, 999, log); //why would log be a problem??
		this.basicAnthills = basicAnthills;
	}

	public  int antsLeft() {
		int n = 0;
		for (Anthill anAnthill : basicAnthills) {
			n = n+anAnthill.antsLeft();
		}
		return n;
	}

	@Override
	public synchronized boolean tryToEatAt(Animal animal) {

		if (arrOfWaiting.isEmpty()) {
			for (Anthill anAnthill : basicAnthills) {
				if (anAnthill.tryToEatAt(animal)) {
					anthillOfAnimal.put(animal, anAnthill);
					return true;
				}else {
					arrOfWaiting.add(animal.getPriority());
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}else {
			if (animal.getPriority() < Collections.max(arrOfWaiting)) {
				arrOfWaiting.add(animal.getPriority());
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				for (Anthill anAnthill : basicAnthills) {
					if (anAnthill.tryToEatAt(animal)) {
						anthillOfAnimal.put(animal, anAnthill);
						return true;
					}else {
						arrOfWaiting.add(animal.getPriority());
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return false;
}

	@Override
	public synchronized void exitAnthill(Animal animal) {
		anthillOfAnimal.remove(animal).exitAnthill(animal);
		arrOfWaiting.clear();
		notifyAll();
	}
}
