package com.supulm.aoc2018.day3;

import java.util.ArrayList;
import java.util.Objects;

public class FabricSlicer {

    private ArrayList<ArrayList<String>> fabric = new ArrayList<>();
    private ArrayList<Claim> claims = new ArrayList<>();

    public FabricSlicer() {
        this.initializeFabric();
    }

    public int processAndGetArea(ArrayList<String> data) {
        processTextData(data);
        for (Claim claim : this.claims) {
            for (int i = claim.getSpaceTop(); i < (claim.getSpaceTop() + claim.getHeight()); i++) {
                for (int j = claim.getSpaceLeft(); j < (claim.getSpaceLeft() + claim.getWidth()); j++) {
                    if ((this.fabric.get(i).get(j)).equals(".")) {
                        this.fabric.get(i).set(j, claim.getId());
                    } else {
                        this.fabric.get(i).set(j, "x");
                    }
                }
            }
        }

        return getMultipleClaimedArea();
    }

    public String getIntactClaimId(ArrayList<String> data) {
        processAndGetArea(data);
        for (Claim claim : this.claims) {
            for (int i = claim.getSpaceTop(); i < (claim.getSpaceTop() + claim.getHeight()); i++) {
                for (int j = claim.getSpaceLeft(); j < (claim.getSpaceLeft() + claim.getWidth()); j++) {
                    if (Objects.equals(this.fabric.get(i).get(j), "")) {

                    }
                }
            }
        }
        return "";
    }

    public int getMultipleClaimedArea() {
        int area = 0;
        for (int i = 0; i < this.fabric.size(); i++) {
            for (int j = 0; j < this.fabric.get(i).size(); j++) {
                if ((this.fabric.get(i).get(j)).equals("x")) area++;
            }
        }
        return area;
    }


    // Sample string - #8 @ 557,190: 19x17
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
