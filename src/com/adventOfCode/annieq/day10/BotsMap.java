package com.adventOfCode.annieq.day10;

import java.util.HashMap;

public class BotsMap {

	private HashMap<Integer, Bot> bots;
	
	public BotsMap() {
		bots = new HashMap<>();
	}
	
	public void put(Integer id, Bot bot) {
		bots.put(id, bot);
	}

	public Bot get(Integer id) {
		if (!bots.containsKey(id)) {
			bots.put(id, new Bot(id));
		}
		return bots.get(id);
	}
	
	public int checkTaskCondition(int low, int high) {
		for (Integer id : bots.keySet()) {
			if (bots.containsKey(id)
					&& bots.get(id).hasTwoValues()
					&& bots.get(id).getLow() == low
					&& bots.get(id).getHigh() == high) {				
				return id;
			}
		}		
		return -1;
	}
	
	public String toString() {
		return bots.toString();
	}
}
