package com.willjsporter.utils;

import java.util.List;
import java.util.Objects;

public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates toCoordinates(List<Integer> list) throws Exception {
        if(list.size()!= 2) {
            throw new Exception("list must be of length 2 but was of length " + list.size());
        }
        return new Coordinates(list.get(0), list.get(1));
    }

    public void moveBy(Coordinates otherCoordinates) {
        x += otherCoordinates.getX();
        y += otherCoordinates.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String printCoordinates() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
