package com.adventOfCode.annieq.day12;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import com.adventOfCode.annieq.utilities.InputImport;

public class Day12 {
	
    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day12-part2.txt");
        List<String> data = in.getMultiLineData();
        
        ListIterator<String> it = data.listIterator();
        while (it.hasNext()) {
        	String line = it.next();
        	String[] chunks = line.split(" ");
        	switch(chunks[0]) {
        	case "cpy":
        		String x = chunks[1];
        		if (x.equals("a")) {
        			cpy(Register.A, chunks[2]);
        		} else if (x.equals("b")) {
        			cpy(Register.B, chunks[2]);
        		} else if (x.equals("c")) {
        			cpy(Register.C, chunks[2]);
        		} else if (x.equals("d")) {
        			cpy(Register.D, chunks[2]);
        		} else {	// copy int value to register
        			cpy(Integer.parseInt(x), chunks[2]);
        		}
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
        		int tmp = 0;
        		if (chunks[1].equals("a")) {
        			tmp = Register.A.getValue();
        		} else if (chunks[1].equals("b")) {
        			tmp = Register.B.getValue();
        		} else if (chunks[1].equals("c")) {
        			tmp = Register.C.getValue();
        		} else if (chunks[1].equals("d")) {
        			tmp = Register.D.getValue();
        		} else {
        			tmp = Integer.parseInt(chunks[1]);
        		}
        		
        		if (tmp > 0) {
        			int step = Integer.parseInt(chunks[2]);
        			if (step < 0) {
        				for (int i=0; i>step-1; --i) {
        					it.previous();
        				}
        			} else {
        				for (int i=0; i<=step-2; ++i) {
        					it.next();
        				}
        			}
        			break;
        		}
        	}
        }
        System.out.println("Register A: " + Register.A.getValue());
    }
    
    private static void cpy(int x, String register) {
    	if (register.equals("a")) {
    		Register.A.setValue(x);
    	} else if (register.equals("b")) {
    		Register.B.setValue(x);
    	} else if (register.equals("c")) {
    		Register.C.setValue(x);
    	} else if (register.equals("d")) {
    		Register.D.setValue(x);
    	}
    }
    
    private static void cpy(Register x, String register) {
    	if (register.equals("a")) {
    		Register.A.setValue(x.getValue());
    	} else if (register.equals("b")) {
    		Register.B.setValue(x.getValue());
    	} else if (register.equals("c")) {
    		Register.C.setValue(x.getValue());
    	} else if (register.equals("d")) {
    		Register.D.setValue(x.getValue());
    	}
    }
    
    private enum Register {
    	A(0), B(0), C(0), D(0);
    	
    	private int value;
    	
    	Register(int val) {
    		setValue(val);
    	}

    	public int getValue() {
    		return value;
    	}

    	public void setValue(int value) {
    		this.value = value;
    	}
    	
    	public void inc() {
    		value++;
    	}
    	
    	public void dec() {
    		value--;
    	}
    }
}
