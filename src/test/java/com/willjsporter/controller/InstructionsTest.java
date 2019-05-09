package com.willjsporter.controller;

import com.willjsporter.Area;
import com.willjsporter.utils.Coordinates;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InstructionsTest {

    @Test
    public void canCreateAreaFromInstructions() throws Exception {

        Instructions instructions = new Instructions(
                List.of(5,5),
                List.of(0,1),
                List.of(
                        List.of(1,1), List.of(1,2)
                ),
                ""
        );
        Area area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(1,2))
        );

        assertThat(instructions.createArea(), is(area));
    }

    @Test
    public void duplicateOilSpillsInInstructionsAreOnlyCountedOnce() throws Exception {

        Instructions instructions = new Instructions(
                List.of(5,5), List.of(0,1), List.of(List.of(1,1), List.of(1,1), List.of(1,2)), ""
        );
        Area area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(1,2))
                );

        assertThat(instructions.createArea(), is(area));
    }

}