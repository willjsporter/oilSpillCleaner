package com.willjsporter.utils;

import java.util.List;

public class ListUtils {

    public static Coordinates toCoordinates(List<Integer> list) {
        if(list.size()!= 2) {
            return new Coordinates(0,0);
        }
        return new Coordinates(list.get(0), list.get(1));
    }
}
