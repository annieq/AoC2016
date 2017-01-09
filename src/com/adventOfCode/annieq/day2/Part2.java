package com.adventOfCode.annieq.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {

        char[][] keypad = new char[][] {
            {'0','0','1','0','0'},
            {'0','2','3','4','0'},
            {'5','6','7','8','9'},
            {'0','A','B','C','0'},
            {'0','0','D','0','0'},
        };
        
        InputImport in = new InputImport("data//day2.txt");
        List<String> data = in.getMultiLineData();
        int[] pointer = new int[] {0,2};
        List<Character> result = new ArrayList<>();
        System.out.println(keypad[pointer[1]][pointer[0]]);
        
        for (String line : data) {
            for (char dir : line.toCharArray()) {
                switch (dir) {
                case 'D':
                    if (pointer[1] < 4 && keypad[pointer[1]+1][pointer[0]] != '0') {
                        ++pointer[1];
                    }
                    break;
                case 'U':
                    if (pointer[1] > 0 && keypad[pointer[1]-1][pointer[0]] != '0') {
                        --pointer[1];
                    }
                    break;
                case 'R':
                    if (pointer[0] < 4 && keypad[pointer[1]][pointer[0]+1] != '0') {
                        ++pointer[0];
                    }
                    break;
                case 'L':
                    if (pointer[0] > 0 && keypad[pointer[1]][pointer[0]-1] != '0') {
                        --pointer[0];
                    }
                    break;
                }
            }
            System.out.println(pointer[0] + ", " + pointer[1]);
            result.add(keypad[pointer[1]][pointer[0]]);
        }
        System.out.println(result);
    }
    
}
