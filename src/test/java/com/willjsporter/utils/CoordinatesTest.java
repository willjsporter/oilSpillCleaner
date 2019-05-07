package com.willjsporter.utils;

import org.junit.Test;

import java.util.List;

import static com.willjsporter.utils.Coordinates.toCoordinates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;


public class CoordinatesTest {

    @Test
    public void shouldMoveCoordinatesByAddingXAndYCoordinatesTogetherRespectively() {
        Coordinates coordinates1 = new Coordinates(1,0);
        Coordinates coordinates2 = new Coordinates(2,4);

        coordinates1.moveBy(coordinates2);

        assertThat(coordinates1, is(new Coordinates(3,4)));
    }

    @Test
    public void shouldBeAbleToConvert2ItemListToCoordinates() throws Exception {
        var listToConvert = List.of(1,2);
        assertThat(toCoordinates(listToConvert), equalTo(new Coordinates(1,2)));
    }

    @Test
    public void listofLengthMoreThan2ShouldThrowException() {
        try {
            toCoordinates(List.of(1,2,3));
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("list must be of length 2 but was of length 3"));
        }
    }

}