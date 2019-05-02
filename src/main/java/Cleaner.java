import utils.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Cleaner {

    private Area area;
    private Coordinates position;
    private ArrayList<Coordinates> directions;


    public Cleaner(Area area, Coordinates position, ArrayList<Coordinates> directions) {
        this.area = area;
        this.position = position;
        this.directions = directions;
    }

    public void nextMove() {
        if(!directions.isEmpty()) {
            position.add(directions.get(0));
            directions.remove(0);
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

}
