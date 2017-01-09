package com.adventOfCode.annieq.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputImport in = new InputImport("data//day1.txt");
		List<String> data = in.getSingleLineData(", ");
		int[] coords = new int[] {0, 0};
		Direction dir = Direction.NORTH;
		int counter = 1;
		List<int[]> visited = new ArrayList<int[]>();
		int[] result = new int[2];
		int stepLength = 0;
		
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
				coords[1] += stepLength;
				for (int i=0; i < stepLength; ++i) {
					//visited.add(coords[0])
				}
				break;
			case SOUTH:
				coords[1] -= stepLength;
				break;
			case EAST:
				coords[0] += stepLength;
				break;
			case WEST:
				coords[0] -= stepLength;
				break;
			}
			System.out.println(counter + ". Step: " + step);
			System.out.println("Direction: " + dir);
			System.out.println("Coords: " + coords[0] + ", " + coords[1]);
			++counter;
		}
		System.out.println("Result: " + result[0] + ", " + result[1]);
	}
}
