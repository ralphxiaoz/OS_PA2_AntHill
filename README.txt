This is part 1&2 of PA2

In part 1 BasicAnthill:
Implementation was mainly on class BasicAnthill. Overrides 2 abstract methods: tryToEatAt(Animal) and exitAnthill(Animal)

tryToEatAt(Animal):
if all conditions met, increment number at the anthill, return true, eat an ant.

exitAnthill(Animal):
decrese number of animal at the anthill, delete the colour of the animal left the anthill

In part 2 ScheduledAnthill:

When a animal enters ScheduledAnthill, if waiting queue is empty, it's scheduled to enter the BasicAntill. If waiting queue is not empty, it compares its priority with the animal with max priority in the waiting queue. If it wins, try to enter a BasicAnthill, otherwise it goes into waiting queue and put to wait.

Once an animal leaves the ScheduledAnthill, it calls notifyAll() to awaken all the animals in the waiting queue and make them start again to enter the ScheduledAnthill.

The constructor called super(String name, int ants, AntLog log). However, since the number ants is private field of Anthill and cannot be modified, I put a rather large number in ants(999).
antsLeft() was overwritten to return the total ants left in the BasicAnthills.

Hashmap<Animal, Anthill> anthillOfAnimal:
Keeping track of the animals in ScheduledAnthill. If animal can eat at a BasicAnthill, put animal & BasicAnthill into Hashmap. When animal is satisfied, remove the animal key and its value from Hashmap.

tryToEatAt(Animal):
Synchronized.
Iterate all the BasicAnthills in the ScheduledAnthill, if animal can eat at certain BasicAnthill, then animal goes in.

exitAnthill(Animal):
Synchronized.
Remove the animal from ScheduledAnthill. Call notifyAll() to awaken the waiting animals.
