package com.willjsporter.controller;

import com.willjsporter.Area;
import com.willjsporter.Cleaner;
import com.willjsporter.utils.Coordinates;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InstructionsTest {

    private Instructions instructions;

    @Before
    public void setUp() {
        instructions = new Instructions(
                List.of(5,5),
                List.of(0,1),
                List.of(List.of(1,1),
                        List.of(1,2)),
                ""
        );
    }

    @Test
    public void canCreateAreaFromInstructions() {
        Area area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(1,2))
        );

        assertThat(instructions.createArea(), is(area));
    }

    @Test
    public void duplicateOilSpillsInInstructionsAreOnlyCountedOnce() {
        instructions = new Instructions(
                List.of(5,5), List.of(0,1), List.of(List.of(1,1), List.of(1,1), List.of(1,2)), ""
        );
        Area area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(1,2))
                );

        assertThat(instructions.createArea(), is(area));
    }

    @Test
    public void canCreateCleanerFromInstructionsWithTrivialInstructions() {
        Cleaner cleaner = new Cleaner(
                new Area(5,5, List.of(new Coordinates(1,1), new Coordinates(1,2))),
                new Coordinates(0,1),
                new ArrayList<>()
        );
        assertThat(instructions.createCleaner(), equalTo(cleaner));
    }

    @Test
    public void canCreateCleanerFromInstructions_IncludingProcessingDirectionsIntoReadableFormat() {
        instructions = new Instructions(
                List.of(5,5),
                List.of(0,1),
                List.of(List.of(1,1),
                        List.of(1,2)),
                "NENSW"
        );

        ArrayList<Coordinates> cleanerDirections = new ArrayList<>();
        cleanerDirections.add(new Coordinates(0, 1));
        cleanerDirections.add(new Coordinates(1, 0));
        cleanerDirections.add(new Coordinates(0, 1));
        cleanerDirections.add(new Coordinates(0, -1));
        cleanerDirections.add(new Coordinates(-1, 0));

        Cleaner cleaner = new Cleaner(
                new Area(5,5, List.of(new Coordinates(1,1), new Coordinates(1,2))),
                new Coordinates(0,1),
                cleanerDirections
        );

        assertThat(instructions.createCleaner(), equalTo(cleaner));
    }

}