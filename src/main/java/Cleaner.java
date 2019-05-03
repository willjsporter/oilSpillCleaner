import utils.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cleaner {

    private Area area;
    private Coordinates position;
    private ArrayList<Coordinates> directions;
    private int totalSpillsCleaned;


    public Cleaner(Area area, Coordinates position, ArrayList<Coordinates> directions) {
        this.area = area;
        this.position = position;
        this.directions = directions;
        this.totalSpillsCleaned = 0;
    }

    public void nextMove() throws Exception {
        if(!directions.isEmpty()) {
            position.moveBy(directions.get(0));
            checkValidPosition();
            directions.remove(0);
            attemptToClean();
        }
    }

    private void checkValidPosition ()throws Exception {
        if( position.getX() < 0                     ||
            position.getX() > area.getxLength() - 1 ||
            position.getY() < 0                     ||
            position.getY() > area.getxLength() - 1 ) {
            throw new Exception("cleaner is out of bounds at position " + position.printCoordinates());
        }
    }

    public Area getArea() {
        return area;
    }

    public Coordinates getPosition() {
        return position;
    }

    public List<Coordinates> getDirections() {
        return directions;
    }

    public int getTotalSpillsCleaned() {
        return totalSpillsCleaned;
    }

    private void attemptToClean() {
        if(area.getOilPatchLocations().contains(position)) {
            totalSpillsCleaned ++;
        }
        area = new Area(
                area.getxLength(),
                area.getyLength(),
                area.getOilPatchLocations()
                        .stream().
                        filter(patch -> !patch.equals(position)).
                        collect(Collectors.toList())
        );
    }

}
