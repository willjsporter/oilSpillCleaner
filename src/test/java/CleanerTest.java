import org.junit.Test;
import utils.Coordinates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class CleanerTest {

    @Test
    public void cleanerShouldStayStationaryIfNoDirectionsAreGiven() {
        Area area = new Area(5, 5, Collections.emptyList());
        Coordinates startingPosition = new Coordinates(0, 0);
        Cleaner cleaner = new Cleaner(area, startingPosition, new ArrayList<>());

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), is(startingPosition));
    }

    @Test
    public void cleanerShouldMoveBasedOnListOfDirections() {
        Area area = new Area(5, 5, List.of());
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
    public void cleanerShouldCountNumberOfOilPatchesCleaned() {
        Area area = new Area(
                5,
                5,
                List.of(new Coordinates(1,1), new Coordinates(4,4))
        );
        var directions = new ArrayList<Coordinates>(List.of(new Coordinates(1,1), new Coordinates(3,2)));
        Cleaner cleaner = new Cleaner(area, new Coordinates(0,0), directions);

        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(0));

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));

        cleaner.nextMove();
        assertThat(cleaner.getTotalSpillsCleaned(), equalTo(1));
    }


}