package p3.lsp2.violation;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Bird> birdList = new ArrayList<Bird>();
	    birdList.add(new Bird());
	    birdList.add(new Crow());
	    birdList.add(new Ostrich());
	    letTheBirdsFly(birdList);
	}
	
	public static void letTheBirdsFly (List<Bird> birdList) {
	    for (Bird bird : birdList) {
	    	try {
	    	   bird.fly();
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}
}
