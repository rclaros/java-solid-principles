package p3.lsp2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Bird> birdList = new ArrayList<Bird>();
	    birdList.add(new Bird());
	    birdList.add(new Crow());
	    birdList.add(new Ostrich());
	    letTheBirdsEat(birdList);
	    
	    List<FlightBird> flightBirdList = new ArrayList<FlightBird>();
	    flightBirdList.add(new Crow());
	    fly(flightBirdList);
	}
	
	public static void letTheBirdsEat(List<Bird> birdList) {
	    for (Bird bird : birdList) {	    	
	    	 bird.eat();	    	
	    }
	}
	
	public static void fly(List<FlightBird> flightBirdList) {
	    for (FlightBird flightBird : flightBirdList) {
	    	 flightBird.fly();
	    }
	}
}
