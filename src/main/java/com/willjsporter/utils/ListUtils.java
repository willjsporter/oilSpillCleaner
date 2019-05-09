package com.willjsporter.utils;

import java.util.List;

public class ListUtils {

    public static Coordinates toCoordinates(List<Integer> list) throws Exception {
        if(list.size()!= 2) {
            throw new Exception("list must be of length 2 but was of length " + list.size());
        }
        return new Coordinates(list.get(0), list.get(1));
    }
}
