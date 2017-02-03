package com.adventOfCode.annieq.day13;

import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.annieq.day1.Coords;

public class Part1_test {
	// puzzle input
	static int input = 10;
	
	static List<Coords> path;
	static Coords position;
	static Coords goal;

    public static void main(String[] args) {
    	position = new Coords(1, 1);
    	//position = new int[] {1, 1};
    	goal = new Coords(7,4);
    	path = new ArrayList<Coords>();
    	
    	System.out.println(go(position.x(), position.y()));
    }
    
    private static boolean isOpenSpace(int x, int y) {
    	int result = x*x + 3*x + 2*x*y + y + y*y + input;
    	String binary = Integer.toBinaryString(result);
    	
    	// count number of "1"s
    	int count = binary.length() - binary.replace("1", "").length();
    	
    	// if number is even, it's an open space
    	return (count % 2 == 0);
    }
    
    private static boolean go(int x, int y) {
    	position.setX(x);
    	position.setY(y);
    	if (position == goal) {
    		System.out.println("FOUND!");
    		return true;
    	}
    	path.add(new Coords(x,y));
    	System.out.println("(" + x + ", " + y + "), path count: " + path.size());
    	if (isOpenSpace(x, y+1) && !positionIsInPath(x, y+1)) {
    		//path.add(new Coords(x, y+1));
    		go (x, y+1);
    	}
    	if (isOpenSpace(x+1, y) && !positionIsInPath(x+1, y)) {
    		//path.add(new Coords(x+1, y));
    		go (x+1, y);
    	}
    	if (isOpenSpace(x, y-1) && !positionIsInPath(x, y-1)) {
    		//path.add(new Coords(x, y-1));
    		go(x, y-1);
    	}
    	if (isOpenSpace(x-1, y) && !positionIsInPath(x-1, y)) {
    		//path.add(new Coords(x-1, y));
    		go(x-1, y);
    	}
    	path.remove(new Coords(x, y));
    	return false;
    }
    
    private static boolean positionIsInPath(int x, int y) {
    	Coords tmp = new Coords(x, y);
    	return (path.contains(tmp));
    }
}
