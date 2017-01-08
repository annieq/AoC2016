package com.adventOfCode.annieq.day1;

public class Coords {
    private int x;
    private int y;
    
    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int x() {
        return x;
    }
    
    public int y() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        Coords tmp = (Coords) obj;
        return (tmp.x == this.x && tmp.y == this.y);
    }
};