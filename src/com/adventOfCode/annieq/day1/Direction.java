package com.adventOfCode.annieq.day1;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum Direction {
	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	
	int value;
	private Direction(int v) { value = v; }
	
	private static final Map<Integer,Direction> lookup 
    = new HashMap<Integer,Direction>();

	static {
		for(Direction w : EnumSet.allOf(Direction.class))
			lookup.put(w.value, w);
	}

	public static Direction get(int code) { 
		return lookup.get(code); 
	}

	public Direction turnRight() {
//		this.value = (this.value + 1) % 4;
//		return this;
		int result = (this.value + 1) % 4;
		return Direction.get(result);
	}
	
	public Direction turnLeft() {
//		this.value = (this.value - 1) % 4;
//		return this;
		int result = this.value - 1;
		if (result == -1) {
			result = 3;
		}
		return Direction.get(result);
	}
}