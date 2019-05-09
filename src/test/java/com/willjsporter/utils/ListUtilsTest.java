package com.willjsporter.utils;

import org.junit.Test;

import java.util.List;

import static com.willjsporter.utils.ListUtils.toCoordinates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ListUtilsTest {

    @Test
    public void shouldBeAbleToConvert2ItemListToCoordinates() {
        var listToConvert = List.of(1,2);
        assertThat(toCoordinates(listToConvert), equalTo(new Coordinates(1, 2)));
    }

    @Test
    public void listofLengthOtherThan2ShouldDefaultToZeroZeroCoordinates() {
        var invalidListToConvert = List.of(2,3,10,14);
        assertThat(toCoordinates(invalidListToConvert), equalTo(new Coordinates(0, 0)));
    }

}