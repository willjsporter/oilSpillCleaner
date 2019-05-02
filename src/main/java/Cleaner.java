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

    public void nextMove() {
        if(!directions.isEmpty()) {
            position.add(directions.get(0));
            directions.remove(0);
            if(area.getOilPatchLocations().contains(position)) {
                totalSpillsCleaned ++;
            }

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

}
