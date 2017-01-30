package com.adventOfCode.annieq.day12;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {
	
    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day12.txt");
        List<String> data = in.getMultiLineData();
        
        Iterator<String> it = data.iterator();
        while (it.hasNext()) {
        	String line = it.next();
        	String[] chunks = line.split(" ");
        	switch(chunks[0]) {
        	case "cpy":
        		// TODO
        		break;
        	case "inc":
        		if (chunks[1].equals("a")) {
        			Register.A.inc();
        		} else if (chunks[1].equals("b")) {
        			Register.B.inc();
        		} else if (chunks[1].equals("c")) {
        			Register.C.inc();
        		} else if (chunks[1].equals("d")) {
        			Register.D.inc();
        		}
        		break;
        	case "dec":
        		if (chunks[1].equals("a")) {
        			Register.A.dec();
        		} else if (chunks[1].equals("b")) {
        			Register.B.dec();
        		} else if (chunks[1].equals("c")) {
        			Register.C.dec();
        		} else if (chunks[1].equals("d")) {
        			Register.D.dec();
        		}
        		break;
        	case "jnz":
        		// TODO
        		break;
        	}
        }
    }
}
