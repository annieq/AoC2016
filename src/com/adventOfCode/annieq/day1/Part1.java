package com.adventOfCode.annieq.day1;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputImport in = new InputImport("data//day1.txt");
		List<String> data = in.getSingleLineData(", ");
		int[] coords = new int[] {0, 0};
		Direction dir = Direction.NORTH;
		int counter = 1;
		
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
			switch (dir) {
			case NORTH:
				coords[1] += Integer.parseInt(step.substring(1));
				break;
			case SOUTH:
				coords[1] -= Integer.parseInt(step.substring(1));
				break;
			case EAST:
				coords[0] += Integer.parseInt(step.substring(1));
				break;
			case WEST:
				coords[0] -= Integer.parseInt(step.substring(1));
				break;
			}
			System.out.println(counter + ". Step: " + step);
			System.out.println("Direction: " + dir);
			System.out.println("Coords: " + coords[0] + ", " + coords[1]);
			++counter;
		}
		System.out.println("Result: " + Math.addExact(Math.abs(coords[0]), Math.abs(coords[1])));
	}

}
