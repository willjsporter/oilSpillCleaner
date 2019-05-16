package com.willjsporter.controller;

import com.willjsporter.cleaner.Area;
import com.willjsporter.cleaner.Cleaner;
import com.willjsporter.utils.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.willjsporter.controller.InstructionsUtils.listToCoordinates;
import static java.util.Arrays.asList;

public class Instructions {
    private List<Integer> areaSize;
    private List<Integer> startingPosition;
    private List<List<Integer>> oilPatches;
    private String navigationInstructions;

    private final Map<String, Coordinates> directionTranslatorMap = Map.of(
            "N", new Coordinates(0,1),
            "E", new Coordinates(1,0),
            "S", new Coordinates(0,-1),
            "W", new Coordinates(-1,0)
    );

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

    public Cleaner createCleaner() {
        return new Cleaner(createArea(), listToCoordinates(startingPosition), instructionsToDirectionsConverter());
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

    private ArrayList<Coordinates> instructionsToDirectionsConverter() {
         List instructionsList = asList(navigationInstructions.split(""))
                 .stream()
                 .filter(entry -> !entry.equals(""))
                 .map(letter -> directionTranslatorMap.get(letter))
                 .collect(Collectors.toList());
        return new ArrayList<Coordinates>(instructionsList);
    }
}
