package com.adventOfCode.annieq.day8;

import java.io.PrintStream;

public class Screen {

    private char[][] scr;
    
    public Screen(int width, int height) {
        scr = new char[width][height];
        for (int i=0; i<width; ++i)
            for (int j=0; j<height; ++j) {
                scr[i][j] = '.';
            }
    }
    
    public void print(PrintStream p) {
        for (int j=0; j<scr[0].length; ++j) {
            for (int i=0; i<scr.length; ++i) {
                p.print(scr[i][j]);
            }
            p.println();
        }
    }
    
    public void rect(int x, int y) {
        for (int i=0; i<x; ++i)
            for (int j=0; j<y; ++j) {
                scr[i][j] = '#';
        }
    }
    
    public void rotateRow(int y, int by) {
        char tmp[] = new char[scr.length];  // will contain modified row
        for (int i=0; i<scr.length; ++i) {
            tmp[i] = scr[(scr.length+i-by)%scr.length][y];
        }
        // move shifted values to the screen
        for (int i=0; i<scr.length; ++i) {
            scr[i][y] = tmp[i];
        }
    }
    
    public void rotateColumn(int x, int by) {
        int length = scr[x].length;
        char tmp[] = new char[length]; // will contain modified column
        for (int i=0; i<length; ++i) {
            tmp[i] = scr[x][(length+i-by)%length];
        }
        // move shifted values to the screen
        for (int i=0; i<length; ++i) {
            scr[x][i] = tmp[i];
        }
    }
    
    public int countLit() {
        int counter = 0;
        for (int j=0; j<scr[0].length; ++j) {
            for (int i=0; i<scr.length; ++i) {
                if (scr[i][j] == '#')
                    ++counter;
            }
        }
        return counter;
    }
}
