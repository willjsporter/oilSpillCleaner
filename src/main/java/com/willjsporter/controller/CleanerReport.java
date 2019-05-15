package com.willjsporter.controller;

import com.willjsporter.utils.Coordinates;

public class CleanerReport {
      private final Coordinates finalPosition;
      private final int oilPatchesCleaned;

    public Coordinates getFinalPosition() {
        return finalPosition;
    }

    public int getOilPatchesCleaned() {
        return oilPatchesCleaned;
    }

    public CleanerReport(Coordinates finalPosition, int oilPatchesCleaned) {
        this.finalPosition = finalPosition;
        this.oilPatchesCleaned = oilPatchesCleaned;
    }
}
