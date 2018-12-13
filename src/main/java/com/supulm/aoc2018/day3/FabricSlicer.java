package com.supulm.aoc2018.day3;

import java.util.ArrayList;
import java.util.Objects;

public class FabricSlicer {

    private ArrayList<ArrayList<String>> fabric = new ArrayList<>();
    private ArrayList<Claim> claims = new ArrayList<>();

    public FabricSlicer() {
        this.initializeFabric();
    }

    public String processAndGetArea(ArrayList<String> data) {
        processTextData(data);
        for (Claim claim : this.claims) {
            for (int i = claim.getSpaceTop(); i < (claim.getSpaceTop() + claim.getHeight()); i++) {
                for (int j = claim.getSpaceLeft(); j < (claim.getSpaceLeft() + claim.getWidth()); j++) {
                    if ((this.fabric.get(i).get(j)).equals(".")) {
                        this.fabric.get(i).set(j, claim.getId());
                    } else {
                        if (!(this.fabric.get(i).get(j)).equals("x")) {
                            // TODO try to improve this using lambdas aka possible removal of getClaimById
                            getClaimById(this.fabric.get(i).get(j)).setIntact(false);
                        }
                        this.fabric.get(i).set(j, "x");
                        claim.setIntact(false);
                    }
                }
            }
        }

        return getMultipleClaimedArea() + ", " + getIntactClaimId();
    }

    public String getIntactClaimId() {
        for (Claim claim : this.claims) {
            if (claim.isIntact()) {
                return claim.getId();
            }
        }
        return null;
    }

    public Claim getClaimById(String id) {
        for (Claim claim : this.claims) {
            if (claim.getId().equals(id)){
                return claim;
            }
        }
        return null;
    }

    public int getMultipleClaimedArea() {
        int area = 0;
        for (ArrayList<String> row : this.fabric) {
            for (String cell : row) {
                if (cell.equals("x")) area++;
            }
        }
        return area;
    }

    public void processTextData(ArrayList<String> lines) {
        for (String line : lines) {
            String stripped = line.replaceAll("\\s+", "");
            stripped += "/";
            String id = stripped.substring(stripped.indexOf("#") + 1, stripped.indexOf("@"));
            int spaceLeft = Integer.valueOf(stripped.substring(stripped.indexOf("@") + 1, stripped.indexOf(",")));
            int spaceTop = Integer.valueOf(stripped.substring(stripped.indexOf(",") + 1, stripped.indexOf(":")));
            int width = Integer.valueOf(stripped.substring(stripped.indexOf(":") + 1, stripped.indexOf("x")));
            int height = Integer.valueOf(stripped.substring(stripped.indexOf("x") + 1, stripped.indexOf("/")));
            Claim claim = new Claim(id, spaceLeft, spaceTop, width, height);
            this.claims.add(claim);
        }
    }

    public void initializeFabric() {
        for (int i = 0; i < 1000; i++) {
            ArrayList<String> width = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                width.add(j, ".");
            }
            this.fabric.add(width);
        }
    }

}
