package com.willjsporter.controller;

import com.willjsporter.Area;
import com.willjsporter.utils.Coordinates;

import java.util.List;
import java.util.stream.Collectors;

import static com.willjsporter.controller.InstructionsUtils.listToCoordinates;

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

    public Area createArea() {
        return new Area(
                areaSize.get(0),
                areaSize.get(1),
                listOflistsToListOfOilPatchCoordinates()
        );
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

    private List<Coordinates> listOflistsToListOfOilPatchCoordinates() {
        return oilPatches
                .stream()
                .map(innerList -> listToCoordinates(innerList))
                .distinct()
                .collect(Collectors.toList());
    }

}
