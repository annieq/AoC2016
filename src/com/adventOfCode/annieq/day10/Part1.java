package com.adventOfCode.annieq.day10;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day10.txt");
        List<String> data = in.getMultiLineData();
        
        for (String line : data) {
            String[] chunks = line.split(" ");
            if (chunks[0].equals("value")) {    // e.g.: "value 23 goes to bot 208" - String[6]
                putToBot(Integer.parseInt(chunks[6]),
                         Integer.parseInt(chunks[1]));
            } else {    // e.g.: "bot 125 gives low to bot 58 and high to bot 57" - String[12]
                
            }
        }
    }
    
    private static void putToBot(int botId, int value) {
        
    }
}
