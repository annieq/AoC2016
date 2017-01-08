package com.adventOfCode.annieq.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {
        
	public static void main(String[] args) throws IOException {
		InputImport in = new InputImport("data//day1.txt");
		List<String> data = in.getSingleLineData(", ");
		Coords coords = new Coords(0, 0);
		Direction dir = Direction.NORTH;
		List<Coords> visited = new ArrayList<Coords>();
		int stepLength = 0;
		boolean intersection = false;
		
		//visited.add(new Coords(2,0));
		
		for (String step : data) {
			// get direction
			if (step.charAt(0) == 'R') {
				dir = dir.turnRight();
//				System.out.println(dir);
			} else if (step.charAt(0) == 'L') {
				dir = dir.turnLeft();
//				System.out.println(dir);
			}
			// go!
			stepLength = Integer.parseInt(step.substring(1));
			switch (dir) {
			case NORTH:
				for (int i=0; i < stepLength; ++i) {
				    Coords tmp = new Coords(coords.x(), coords.y() + i);
					if (visited.contains(tmp)) {
					    intersection = true;
					    coords = tmp;
					    break;
					} else {
					    visited.add(tmp);					    
					}
				}
				if (!intersection)
				    coords.setY(coords.y() + stepLength);
				break;
			case SOUTH:
                for (int i=0; i < stepLength; ++i) {
                    Coords tmp = new Coords(coords.x(), coords.y() - i);
                    if (visited.contains(tmp)) {
                        intersection = true;
                        coords = tmp;
                        break;
                    } else {
                        visited.add(tmp);                       
                    }                   
                }
                if (!intersection)
                    coords.setY(coords.y() - stepLength);
				break;
			case EAST:
                for (int i=0; i < stepLength; ++i) {
                    Coords tmp = new Coords(coords.x() + i, coords.y());
                    if (visited.contains(tmp)) {
                        intersection = true;
                        coords = tmp;
                        break;
                    } else {
                        visited.add(tmp);                       
                    }                                      
                }
                if (!intersection)
                    coords.setX(coords.x() + stepLength);
				break;
			case WEST:
                for (int i=0; i < stepLength; ++i) {
                    Coords tmp = new Coords(coords.x() - i, coords.y());
                    if (visited.contains(tmp)) {
                        intersection = true;
                        coords = tmp;
                        break;
                    } else {
                        visited.add(tmp);                       
                    }                                      
                }
                if (!intersection)
                    coords.setX(coords.x() - stepLength);
				break;
			}
//			System.out.println(counter + ". Step: " + step);
//			System.out.println("Direction: " + dir);
//			System.out.println("Coords: " + coords[0] + ", " + coords[1]);
//			++counter;
			if (intersection) {
			    break;
			}
		}
		System.out.println("Result: " + coords.x() + ", " + coords.y());
		System.out.println(Math.addExact(Math.abs(coords.x()), Math.abs(coords.y())));
	}
	
}
