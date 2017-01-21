package com.adventOfCode.annieq.day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	private static Map<Integer, Bot> bots;
	private static Map<Integer, Integer> outputs;
    private static List<String> queue;
	
    public static void main(String[] args) throws IOException {
    	bots = new HashMap<Integer, Bot>();
    	queue = new ArrayList<String>();
        InputImport in = new InputImport("data//day10.txt");
        List<String> data = in.getMultiLineData();
        
        for (String line : data) {
            String[] chunks = line.split(" ");
            if (chunks[0].equals("value")) {    // e.g.: "value 23 goes to bot 208" - String[6]
                putToBot(Integer.parseInt(chunks[5]),
                         Integer.parseInt(chunks[1]));
            } else {    // e.g.: "bot 125 gives low to bot 58 and high to bot 57" - String[12]
            	if (checkQueue()) {
            		break;
            	}
            	
                int botId = Integer.parseInt(chunks[1]);
                if (bots.containsKey(botId)
                		&& bots.get(botId).hasTwoValues()) {
                	compareAndGiveToBots(line);
                	
                	int lowReceiverId = Integer.parseInt(chunks[6]);
                	int highReceiverId = Integer.parseInt(chunks[11]);
                	
                	// check the task condition
                	if (bots.containsKey(lowReceiverId)
                			&& bots.get(lowReceiverId).hasTwoValues()
                			&& bots.get(lowReceiverId).getLow() == 17 
                			&& bots.get(lowReceiverId).giveHigh() == 61) {
                		System.out.println("Bot ID: " + bots.get(lowReceiverId).getId());
                		break;
                	}
                	if (bots.containsKey(highReceiverId)
                			&& bots.get(highReceiverId).hasTwoValues()
                			&& bots.get(highReceiverId).getLow() == 17 
                			&& bots.get(highReceiverId).giveHigh() == 61) {
                		System.out.println("Bot ID: " + bots.get(highReceiverId).getId());
                		break;
                	}
                } else {	// bot doesn't have two values; put to queue
                	queue.add(line);
                }
            }
        }
    }
    
    private static void putToBot(int botId, int value) {
        // firstly, check if such bot is already in the list
    	if (bots.containsKey(botId)) {
    		bots.get(botId).addChip(value);
    	} else {	// if not, we have to add it
    		Bot bot = new Bot(botId, value);
    		bots.put(botId, bot);
    	}
    }
    
    private static void compareAndGiveToBots(String line) {
        String[] chunks = line.split(" ");
        int botId = Integer.parseInt(chunks[1]);
    	Bot donor = new Bot(botId,
    			bots.get(botId).getLow(),
    			bots.get(botId).getHigh());
    	int lowReceiverId = Integer.parseInt(chunks[6]);
    	if (!bots.containsKey(lowReceiverId)) {
    		bots.put(lowReceiverId, new Bot(lowReceiverId));
    	}
    	int highReceiverId = Integer.parseInt(chunks[11]);
    	if (!bots.containsKey(highReceiverId)) {
    		bots.put(highReceiverId, new Bot(highReceiverId));
    	}
    	bots.get(lowReceiverId).addChip(donor.giveLow());
    	bots.get(highReceiverId).addChip(donor.giveHigh());
    }
    
    /**
     * 
     * @return if task condition is met
     */
    private static boolean checkQueue() {
    	for (String line : queue) {
            String[] chunks = line.split(" ");
            int botId = Integer.parseInt(chunks[1]);
    		if (bots.containsKey(botId)
            		&& bots.get(botId).hasTwoValues()) {
    			compareAndGiveToBots(line);
    		}
    		
        	int lowReceiverId = Integer.parseInt(chunks[6]);
        	int highReceiverId = Integer.parseInt(chunks[11]);
        	
        	// check the task condition
        	if (bots.containsKey(lowReceiverId)
        			&& bots.get(lowReceiverId).hasTwoValues()
        			&& bots.get(lowReceiverId).getLow() == 17 
        			&& bots.get(lowReceiverId).giveHigh() == 61) {
        		System.out.println("Bot ID: " + bots.get(lowReceiverId).getId());
        		return true;
        	}
        	if (bots.containsKey(highReceiverId)
        			&& bots.get(highReceiverId).hasTwoValues()
        			&& bots.get(highReceiverId).getLow() == 17 
        			&& bots.get(highReceiverId).giveHigh() == 61) {
        		System.out.println("Bot ID: " + bots.get(highReceiverId).getId());
        		return true;
        	}
    	}
    	return false;
    }
}
