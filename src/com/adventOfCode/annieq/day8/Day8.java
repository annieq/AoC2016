package com.adventOfCode.annieq.day8;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Day8 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day8.txt");
        List<String> data = in.getMultiLineData();
        Screen scr = new Screen(50, 6);
        
        for (String line : data) {
            String[] chunks = line.split(" ");
            if (chunks[0].equals("rect")) {
                String[] rectData = chunks[1].split("x");
                int x = Integer.parseInt(rectData[0]);
                int y = Integer.parseInt(rectData[1]);
                scr.rect(x, y);
            } else if (chunks[0].equals("rotate")) {
                int i = Integer.parseInt(chunks[2].substring(2));
                int by = Integer.parseInt(chunks[4]);
                if (chunks[1].equals("row")) {
                    scr.rotateRow(i, by);
                } else if (chunks[1].equals("column")) {
                    scr.rotateColumn(i, by);
                }
            }
        }
        // part 1
        System.out.println(scr.countLit());
        // part 2
        scr.print(System.out);
    }
}
