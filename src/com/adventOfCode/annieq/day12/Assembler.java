package com.adventOfCode.annieq.day12;

public class Assembler {
	// registers
	int a, b, c, d;
	
	public Assembler() {
		a = 0;
		b = 0;
		c = 0;
		d = 0;
	}
	
	public void inc(Register reg) {
		switch (reg) {
		case A:
			++a;
			break;
		case B:
			++b;
			break;
		case C:
			++c;
			break;
		case D:
			++d;
			break;
		}
	}
	
	public void dec(Register reg) {
		switch (reg) {
		case A:
			--a;
			break;
		case B:
			--b;
			break;
		case C:
			--c;
			break;
		case D:
			--d;
			break;
		}
	}
	
	public void cpy(int x, Register y) {
		//TODO
	}
	
	public void cpy(Register x, Register y) {
		// TODO
	}

	public enum Register {
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
