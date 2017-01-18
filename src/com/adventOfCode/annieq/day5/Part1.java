package com.adventOfCode.annieq.day5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part1 {

    public static void main(String[] args) {
        String input = "ffykfhsq";
        
        String hash, hashed;
        Integer counter = -1;
        StringBuilder result = new StringBuilder();
        
        for (int i=0; i<8; ++i) {
            do  {
                counter++;
                hash = input + counter.toString();
                hashed = getHash(hash);
            } while (!hashed.startsWith("00000"));
            result.append(hashed.substring(5, 6));
            System.out.println(getHash(hash));
        }
        System.out.println(result.toString());

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
