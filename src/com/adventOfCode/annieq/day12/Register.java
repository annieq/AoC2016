package com.adventOfCode.annieq.day12;

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
