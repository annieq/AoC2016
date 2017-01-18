package com.adventOfCode.annieq.day7;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	public static void main(String[] args) throws IOException {
		InputImport in = new InputImport("data//day7.txt");
		List<String> data = in.getMultiLineData();
		int counter = 0;
		
		for (String ip : data) {
			String[] ipParts = ip.split("\\[|\\]");
			boolean isValid = false;
			
			for (int i=0; i<ipParts.length; i+=2) {
				if (hasABBA(ipParts[i]))
					isValid = true;
			}
			for (int i=0; i<ipParts.length-1; i+=2) {
				if (hasABBA(ipParts[i+1]))
					isValid = false;
			}
			if (isValid)
				++counter;
		}
		System.out.println(counter);
	}
	
	private static boolean hasABBA(String input) {
		for (int i=0; i<input.length()-3; ++i) {
			if (input.charAt(i) != input.charAt(i+1)
					&& input.charAt(i+1) == input.charAt(i+2)
					&& input.charAt(i) == input.charAt(i+3))
				return true;
		}
		return false;
	}
}
