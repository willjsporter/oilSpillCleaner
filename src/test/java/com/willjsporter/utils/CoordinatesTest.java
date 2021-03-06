package com.willjsporter.utils;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CoordinatesTest {

    @Test
    public void shouldMoveCoordinatesByAddingXAndYCoordinatesTogetherRespectively() {
        Coordinates coordinates1 = new Coordinates(1,0);
        Coordinates coordinates2 = new Coordinates(2,4);

        coordinates1.moveBy(coordinates2);

        assertThat(coordinates1, is(new Coordinates(3,4)));
    }

}