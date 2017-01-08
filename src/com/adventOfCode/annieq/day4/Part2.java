package com.adventOfCode.annieq.day4;

import java.io.IOException;
import java.util.List;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part2 {

    public static void main(String[] args) throws IOException {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        int id;
        
        InputImport in = new InputImport("data//day4.txt");
        List<String> data = in.getMultiLineData();

        for (String room : data) {
            StringBuilder sb = new StringBuilder(room.substring(0, room.indexOf('[')));
            room = sb.toString();
            id = Integer.parseInt(room.replaceAll("\\D", ""));
            room = room.replaceAll("\\d", "");
            //System.out.println(room + " " + id);
            
            sb.setLength(0);    // clear the buffer
            for (char c : room.toCharArray()) {
                if (c == '-') {
                    sb.append(" ");
                } else {
                    sb.append(chars.charAt((chars.indexOf(c) + id) % chars.length() ));
                }
            }
            System.out.println(id + ": " + sb.toString());
            if (sb.toString().contains("north"))
                break;
        }
    }

}
