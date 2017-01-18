package com.adventOfCode.annieq.day10;

public class Bot {

    // always start putting values to 'low'
    private Integer low = null;
    private Integer high = null;
    private Integer id;
    
    public Bot(int id) {
        this.id = id;
    }
    
    public Bot(int id, Integer a) {
        this.id = id;
        low = a;
    }
    
    public Bot(int id, Integer a, Integer b) {
        this.id = id;
        
        if (a <= b) {
            low = a;
            high = b;
        } else {
            low = b;
            high = a;
        }
    }
    
    public void addChip(int value) {
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
    
    public int getLow() {
        return low;
    }
    
    public int getHigh() {
        return high;
    }
    
    public int getId() {
        return id;
    }
    
    public String toString() {
    	return id.toString();
    }
    
//    /**
//     * frees low hand and returns its value. If bot has something in high hand, it's moved to low
//     * @return low (given) value
//     */
//    public int giveLowExt() {
//    	
//    }
    
    /**
     * frees low hand and returns its value
     * @return low (given) value
     */
    public int giveLow() {
    	int tmp = low;
    	low = null;
    	return tmp;
    }
    
    /**
     * frees high hand and returns its value
     * @return high (given) value
     */
    public int giveHigh() {
    	int tmp = high;
    	high = null;
    	return tmp;
    }
}
