package com.adventOfCode.annieq.day13;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
	// puzzle input
	static int input = 1362;
	
	static List<int[]> path;
	static int[] position;
	static int[] goal;

    public static void main(String[] args) {
    	position = new int[] {1, 1};
    	goal = new int[] {31, 39};
    	path = new ArrayList<int[]>();
    	
    	go(position[0], position[1]);
    }
    
    private static boolean isOpenSpace(int x, int y) {
    	int result = x*x + 3*x + 2*x*y + y + y*y + input;
    	String binary = Integer.toBinaryString(result);
    	
    	// count number of "1"s
    	int count = binary.length() - binary.replace("0", "").length();
    	
    	// if number is even, it's an open space
    	return (count % 2 == 0);
    }
    
    private static void go(int x, int y) {
    	position[0] = x;
    	position[1] = y;
    	if (position[0] == goal[0] && position[1] == goal[1]) {
    		System.out.println("FOUND!");
    		return;
    	}
    	System.out.println("(" + x + ", " + y + ")");
    	if (isOpenSpace(x, y+1)) {
    		go (x, y+1);
    	}
    	if (isOpenSpace(x+1, y)) {
    		go (x+1, y);
    	}
    	if (isOpenSpace(x, y-1)) {
    		go(x, y-1);
    	}
    	if (isOpenSpace(x-1, y)) {
    		go(x-1, y);
    	}
    }
}
