package com.adventOfCode.annieq.day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.adventOfCode.annieq.utilities.InputImport;

public class Day10 {

	private static BotsMap bots;
	private static Map<Integer, Integer> outputs;
    
    public static void main(String[] args) throws IOException {
    	bots = new BotsMap();
    	outputs = new HashMap<>();
    	List<String> queue = new ArrayList<String>();
        InputImport in = new InputImport("data//day10.txt");
        List<String> data = in.getMultiLineData();

        for (String line : data) {
            String[] chunks = line.split(" ");
            if (chunks[0].equals("value")) {    // e.g.: "value 23 goes to bot 208" - String[6]
                bots.get(Integer.parseInt(chunks[5])).addChip(Integer.parseInt(chunks[1]));
            } else {    // e.g.: "bot 125 gives low to bot 58 and high to bot 57" - String[12]
            	checkQueue(queue);
            	
            	int botId = Integer.parseInt(chunks[1]);
            	if (!bots.get(botId).hasTwoValues()) {
            		queue.add(line);
            		continue;
            	}
            	compareAndGiveValues(line);
            }
            int result = bots.checkTaskCondition(17, 61);
            if (result != -1) {
            	System.out.println("Part 1 answer: " + result);
//            	break;
            }
        }
        while(!queue.isEmpty()) {
        	checkQueue(queue);
            int result = bots.checkTaskCondition(17, 61);
            if (result != -1) {
            	System.out.println("Part 1 answer: " + result);
//            	break;
            }
        }
        System.out.println("Bots: " + bots);
        System.out.println("Outputs: " + outputs);
        
        System.out.println("Part 2 answer: " + outputs.get(0) * outputs.get(1) * outputs.get(2));
    }
    
    private static void compareAndGiveValues(String line) {
        String[] chunks = line.split(" ");
        int botId = Integer.parseInt(chunks[1]);
        int lowReceiverId = Integer.parseInt(chunks[6]);
        int highReceiverId = Integer.parseInt(chunks[11]);
    	
        if (chunks[5].equals("bot")) {
            bots.get(lowReceiverId).addChip(bots.get(botId).giveLow());
        } else if (chunks[5].equals("output")) {
        	outputs.put(lowReceiverId, bots.get(botId).giveLow());
        }

        if (chunks[10].equals("bot")) {
            bots.get(highReceiverId).addChip(bots.get(botId).giveHigh());
        } else if (chunks[10].equals("output")) {
        	outputs.put(highReceiverId, bots.get(botId).giveHigh());
        }
    }
    
    private static void checkQueue(List<String> queue) {
    	Iterator<String> it = queue.iterator();
    	while(it.hasNext()) {
    		String line = it.next();
            String[] chunks = line.split(" ");
            int botId = Integer.parseInt(chunks[1]);
            if (bots.get(botId).hasTwoValues()) {
            	compareAndGiveValues(line);
            	it.remove();
            }

            int result = bots.checkTaskCondition(17, 61);
            if (result != -1) {
                System.out.println("Part 1 answer: " + result);
//                return;
            }
    	}
    }
}
