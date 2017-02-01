package com.adventOfCode.annieq.day13;

public class Part1 {
	// puzzle input
	int input = 1362;

    public static void main(String[] args) {
    	int[] position = new int[] {1, 1};
    	
    }
    
    private boolean isOpenSpace(int x, int y) {
    	int result = x*x + 3*x + 2*x*y + y + y*y + input;
    	String binary = Integer.toBinaryString(result);
    	
    	// count number of "1"s
    	int count = binary.length() - binary.replace("0", "").length();
    	
    	// if number is even, it's an open space
    	return (count % 2 == 0);
    }
}
