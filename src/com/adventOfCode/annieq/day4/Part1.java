package com.adventOfCode.annieq.day4;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.adventOfCode.annieq.utilities.InputImport;

public class Part1 {

    public static void main(String[] args) throws IOException {
        InputImport in = new InputImport("data//day4.txt");
        List<String> data = in.getMultiLineData();
        int sum = 0;
        String id, checksum;
       
        for (String room : data) {
            StringBuilder sb = new StringBuilder(room.replace("-", ""));
            room = sb.toString();
            // aaaaa-bbb-z-y-x-123[abxyz]
            //        ^         ^     ^
            //      room       id  checksum
            checksum = sb.substring(room.indexOf('[')+1, room.indexOf(']'));
            room = sb.substring(0, room.indexOf('['));
            id = room.replaceAll("\\D", "");
            room = room.replaceAll("\\d", "");
            
            Map<Character, Integer> letters = new HashMap<>();
            for (char c : room.toCharArray()) {
                if (letters.containsKey(c)) {
                    letters.put(c, letters.get(c) + 1);
                } else {
                    letters.put(c, 1);
                }
            }
            List<Map.Entry<Character, Integer>> list =
                    new LinkedList<Map.Entry<Character, Integer>>( letters.entrySet() );
            Collections.sort( list, new Comparator<Map.Entry<Character, Integer>>()
            {
                public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
                {
                    if (o1.getValue() < o2.getValue()) return 1;
                    else if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else return -1;
                }
            } );

//            Map<Character, Integer> result = new LinkedHashMap<Character, Integer>();
//            for (Map.Entry<Character, Integer> entry : list)
//            {
//                result.put( entry.getKey(), entry.getValue() );
//            }
            
            StringBuilder sb2 = new StringBuilder();
            for (int i=0; i<5; ++i) {
                //sb2.append(list.get(list.size()-i).getKey());
                sb2.append(list.get(i).getKey());
            }
            if (sb2.toString().equals(checksum)) {
                sum += Integer.parseInt(id);
            }

//            System.out.println(list.get(list.size()-1).getKey() + ""
//                    + list.get(list.size()-2).getKey()  + ""
//                    + list.get(list.size()-3).getKey());
        }
        System.out.println(sum);
    }
   
}