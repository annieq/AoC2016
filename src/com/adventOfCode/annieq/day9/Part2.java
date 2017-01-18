package com.adventOfCode.annieq.day9;

import java.io.IOException;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day9.txt");
        String data = in.getSingleLineData();
        int iterator = 0;
        StringBuilder sb = new StringBuilder(data);
        
        while (iterator < sb.length()) {
            if (sb.charAt(iterator) == '(') {
                int endmarker = sb.indexOf(")", iterator);
                String[] markers = sb.substring(iterator+1, endmarker).split("x");
                // String to be decoded
                String multiplicator = sb.substring(endmarker+1, endmarker+1+Integer.parseInt(markers[0]));
                // number of repetitions
                int repetitions = Integer.parseInt(markers[1]);
                for (int i=0; i<repetitions-1; ++i) {
                    sb.insert(endmarker+1, multiplicator);                    
                }
                sb = sb.delete(iterator, endmarker+1);
            } else {
                ++iterator;
            }
        }
        System.out.println(sb.length());
        //System.out.println(sb.toString());
    }
}
