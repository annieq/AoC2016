package com.adventOfCode.annieq.day10;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

	private static Map<Integer, Bot> bots;
	
    public static void main(String[] args) throws IOException {
    	bots = new HashMap<Integer, Bot>();
        InputImport in = new InputImport("data//day10.txt");
        List<String> data = in.getMultiLineData();
        
        for (String line : data) {
            String[] chunks = line.split(" ");
            if (chunks[0].equals("value")) {    // e.g.: "value 23 goes to bot 208" - String[6]
                putToBot(Integer.parseInt(chunks[5]),
                         Integer.parseInt(chunks[1]));
            } else {    // e.g.: "bot 125 gives low to bot 58 and high to bot 57" - String[12]
                int botId = Integer.parseInt(chunks[1]);
                Bot donor = new Bot(botId,
                					bots.get(botId).getLow(),
                					bots.get(botId).getHigh());
                int lowReceiverId = Integer.parseInt(chunks[6]);
                int highReceiverId = Integer.parseInt(chunks[11]);
                bots.get(lowReceiverId).addChip(donor.giveLow());
                bots.get(highReceiverId).addChip(donor.giveHigh());
                
                // check the task condition
                if (bots.get(lowReceiverId).getLow() == 17 
                		&& bots.get(lowReceiverId).giveHigh() == 61) {
                	System.out.println("Bot ID: " + bots.get(lowReceiverId).getId());
                	break;
                }
                if (bots.get(highReceiverId).getLow() == 17 
                		&& bots.get(highReceiverId).giveHigh() == 61) {
                	System.out.println("Bot ID: " + bots.get(highReceiverId).getId());
                	break;
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
}
