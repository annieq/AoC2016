package com.adventOfCode.annieq.day7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

	public static void main(String[] args) throws IOException {
		InputImport in = new InputImport("data//day7.txt");
		List<String> data = in.getMultiLineData();
		int counter = 0;
		
		for (String ip : data) {
			boolean isValid = false;
			String[] ipParts = ip.split("\\[|\\]");
			List<String> ABAs = new ArrayList<String>();

			for (int i=0; i<ipParts.length; i+=2) {
				List<String> tmp = getABAs(ipParts[i]);
				ABAs.addAll(tmp);
			}
			for (String ABA : ABAs) {
				for (int i=0; i<ipParts.length-1; i+=2) {
					if (hasBAB(ipParts[i+1], ABA))
						isValid = true;
				}
			}
			if (isValid)
				++counter;
		}
		System.out.println(counter);
	}
	
	private static List<String> getABAs(String input) {
		List<String> ABAs = new ArrayList<String>();
		
		for (int i=0; i<input.length()-2; ++i) {
			if (input.charAt(i) != input.charAt(i+1)
					&& input.charAt(i) == input.charAt(i+2)) {
				ABAs.add(input.substring(i, i+2));
			}
		}
		return ABAs;
	}
	
	private static boolean hasBAB(String input, String ABA) {
		StringBuilder sb = new StringBuilder();
		sb.append(ABA.charAt(1));
		sb.append(ABA.charAt(0));
		sb.append(ABA.charAt(1));
		
		return input.contains(sb.toString());
	}
}
