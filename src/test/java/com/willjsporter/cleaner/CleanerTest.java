package com.willjsporter.cleaner;

import com.willjsporter.cleaner.Area;
import com.willjsporter.cleaner.Cleaner;
import com.willjsporter.utils.Coordinates;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;


public class CleanerTest {

    private Area area;

    @Before
    public void setUp() {
        area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(4,4))
        );
    }

    @Test
    public void cleanerShouldStayStationaryIfNoDirectionsAreGiven() throws Exception{
        Coordinates startingPosition = new Coordinates(0, 0);
        Cleaner cleaner = new Cleaner(area, startingPosition, new ArrayList<>());

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), is(startingPosition));
    }

    @Test
    public void cleanerShouldMoveBasedOnListOfDirections() throws Exception {
        Coordinates startingPosition = new Coordinates(0, 0);
        var directions = new ArrayList<Coordinates>(List.of(
                new Coordinates(1, 0),
                new Coordinates(2, 1),
                new Coordinates(-1, 3)
        ));

        Cleaner cleaner = new Cleaner(area, startingPosition, directions);

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(1, 0)));

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(3, 1)));

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(2, 4)));
    }

    @Test
    public void cleanerShouldCountNumberOfOilPatchesCleaned() throws Exception {
        var directions = new ArrayList<Coordinates>(List.of(new Coordinates(1,1), new Coordinates(3,2)));
        Cleaner cleaner = new Cleaner(area, new Coordinates(0,0), directions);

        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(0));

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));
    }

    @Test
    public void cleanerShouldOnlyCountEachPatchCleanedOnce() throws Exception {
        var directions = new ArrayList<Coordinates>(List.of(new Coordinates(1,1), new Coordinates(0,0)));
        Cleaner cleaner = new Cleaner(area, new Coordinates(0,0), directions);

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));
    }

    @Test
    public void shouldThrowErrorIfCleanerGoesOutOfArea() throws Exception {
        var directions = new ArrayList<Coordinates>(List.of(new Coordinates(-1,1)));
        Cleaner cleaner = new Cleaner(area, new Coordinates(0,0), directions);

        try {
            cleaner.nextMove();
            fail("cleaner.nextMove() should have thrown an error but did not");
        } catch (Exception e) {
            String expectedError = "cleaner is out of bounds at position (-1,1)";
            assertThat(e.getMessage(), is(expectedError));
        }

    }

}