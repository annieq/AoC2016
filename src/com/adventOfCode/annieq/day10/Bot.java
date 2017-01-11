package com.adventOfCode.annieq.day10;

public class Bot {

    // always start putting values to 'low'
    private Integer low = null;
    private Integer high = null;
    private int id;
    
    Bot(int id) {
        this.id = id;
    }
    
    Bot(int id, Integer a) {
        this.id = id;
        low = a;
    }
    
    Bot(int id, Integer a, Integer b) {
        this.id = id;
        
        if (a <= b) {
            low = a;
            high = b;
        } else {
            low = b;
            high = a;
        }
    }
    
    void addChip(int value) {
        if (low == null) {
            low = value;
            return;
        }
        
        if (value < low) {
            high = low;
            low = value;
        } else {
            high = value;
        }
    }
    
    int getLow() {
        return low;
    }
    
    int getHigh() {
        return high;
    }
    
    int getId() {
        return id;
    }
}
