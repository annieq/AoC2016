package com.adventOfCode.annieq.day3;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	public static void main(String[] args) throws IOException {
		InputImport in = new InputImport("data//day3.txt");
		List<String> data = in.getMultiLineData();
		int counter = 0;
		
		for (String triangle : data) {
			String[] stringSides = triangle.replaceAll("(^\\s+|\\s+$)", "").split(" +");
			Integer[] sides = new Integer[3];
			for (int i=0; i<3; ++i) {
				sides[i] = Integer.parseInt(stringSides[i]);
			}
			if (checkIfValidTriangle(sides[0], sides[1], sides[2])) {
				++counter;
			}
		}
		System.out.println(counter);
	}
	
	private static boolean checkIfValidTriangle(int a, int b, int c) {
		if (a < b + c && b < a + c && c < a + b)
			return true;
		return false;
	}
}
