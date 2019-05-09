package com.willjsporter;

import com.willjsporter.utils.Coordinates;

import java.util.List;
import java.util.Objects;

public class Area {

    private final int xLength;
    private final int yLength;
    private final List<Coordinates> oilPatchLocations;


    public Area(int xLength, int yLength, List<Coordinates> oilPatchLocations) {
        this.xLength = xLength;
        this.yLength = yLength;
        this.oilPatchLocations = oilPatchLocations;
    }

    public int getxLength() {
        return xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public List<Coordinates> getOilPatchLocations() {
        return oilPatchLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;
        Area area = (Area) o;
        return getxLength() == area.getxLength() &&
                getyLength() == area.getyLength() &&
                getOilPatchLocations().equals(area.getOilPatchLocations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxLength(), getyLength(), getOilPatchLocations());
    }

}
