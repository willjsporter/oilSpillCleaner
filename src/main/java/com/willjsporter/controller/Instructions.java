package com.willjsporter.controller;

import java.util.List;

public class Instructions {
    private List<Integer> areaSize;
    private List<Integer> startingPosition;
    private List<List<Integer>> oilPatches;
    private String navigationInstructions;

    public Instructions(List<Integer> areaSize, List<Integer> startingPosition, List<List<Integer>> oilPatches, String navigationInstructions) {
        this.areaSize = areaSize;
        this.startingPosition = startingPosition;
        this.oilPatches = oilPatches;
        this.navigationInstructions = navigationInstructions;
    }

    public List<Integer> getAreaSize() {
        return areaSize;
    }

    public List<Integer> getStartingPosition() {
        return startingPosition;
    }

    public List<List<Integer>> getOilPatches() {
        return oilPatches;
    }

    public String getNavigationInstructions() {
        return navigationInstructions;
    }
}
