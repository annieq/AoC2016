package com.adventOfCode.annieq.day3;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

	public static void main(String[] args) throws IOException {
		InputImport in = new InputImport("data//day3.txt");
		List<String> data = in.getMultiLineData();
		int counter = 0;
		
		for (int i=0; i<data.size(); i+=3) {
			String[] stringSides1 = data.get(i).replaceAll("(^\\s+|\\s+$)", "").split(" +");
			String[] stringSides2 = data.get(i+1).replaceAll("(^\\s+|\\s+$)", "").split(" +");
			String[] stringSides3 = data.get(i+2).replaceAll("(^\\s+|\\s+$)", "").split(" +");
			Integer[] sides1 = new Integer[3];
			Integer[] sides2 = new Integer[3];
			Integer[] sides3 = new Integer[3];
			sides1[0] = Integer.parseInt(stringSides1[0]);
			sides1[1] = Integer.parseInt(stringSides2[0]);
			sides1[2] = Integer.parseInt(stringSides3[0]);
			sides2[0] = Integer.parseInt(stringSides1[1]);
			sides2[1] = Integer.parseInt(stringSides2[1]);
			sides2[2] = Integer.parseInt(stringSides3[1]);
			sides3[0] = Integer.parseInt(stringSides1[2]);
			sides3[1] = Integer.parseInt(stringSides2[2]);
			sides3[2] = Integer.parseInt(stringSides3[2]);
			if (checkIfValidTriangle(sides1[0], sides1[1], sides1[2])) {
				++counter;
			}
			if (checkIfValidTriangle(sides2[0], sides2[1], sides2[2])) {
				++counter;
			}
			if (checkIfValidTriangle(sides3[0], sides3[1], sides3[2])) {
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
