package com.adventOfCode.annieq.day6;

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
        InputImport in = new InputImport("data//day6.txt");
        List<String> data = in.getMultiLineData();
        char tmp;
        StringBuilder result = new StringBuilder();

        for (int i=0; i<data.get(0).length(); ++i) { // for every position
            Map<Character, Integer> letters = new HashMap<>();
            for (int j=0; j<data.size(); ++j) { // for every line in 'data'
                tmp = data.get(j).charAt(i);
                if (letters.containsKey(tmp)) {
                    letters.put(tmp, letters.get(tmp) + 1);
                } else {
                    letters.put(tmp, 1);
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
            result.append(list.get(0).getKey());
        }
        System.out.println(result.toString());
    }
}

