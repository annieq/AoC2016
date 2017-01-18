package com.adventOfCode.annieq.day5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part2 {

    public static void main(String[] args) {
        String input = "ffykfhsq";
        
        String hash;
        Integer counter = -1;
        char[] pass = new char[] {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        Character position;
        char passPart;
        
        while (true) {
            if (isPasswordComplete(pass)) {
                break;
            }
            do  {
                counter++;
                hash = getHash(input + counter.toString());
            } while (!hash.startsWith("00000"));
            position = hash.substring(5, 6).toCharArray()[0];
            if (Character.isDigit(position)) {
                if (Integer.parseInt(position.toString()) > 7) {
                    continue;
                }
                passPart = hash.substring(6, 7).toCharArray()[0];
                if (pass[Integer.parseInt(position.toString())] == ' ') {
                    pass[Integer.parseInt(position.toString())] = passPart;
                }
            } else {
                continue;
            }
        }
        System.out.println(pass);

    }
    
    private static boolean isPasswordComplete(char[] pass) {
        boolean complete = true;
        for (char c : pass) {
            if (c == ' ') {
                complete = false;
                break;
            }
        }        
        return complete;
    }
    
    private static String getHash(String input) {
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] data = input.getBytes(); 
        md.update(data,0,data.length);
        BigInteger i = new BigInteger(1,md.digest());
        return String.format("%1$032X", i);
    }
}
