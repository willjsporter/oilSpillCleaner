package com.willjsporter.controller;

import com.willjsporter.utils.Coordinates;

import java.util.List;

class InstructionsUtils {

    static Coordinates listToCoordinates(List<Integer> list) {
        if(list.size()!= 2) {
            return new Coordinates(0,0);
        }
        return new Coordinates(list.get(0), list.get(1));
    }
}
