package com.supulm.aoc2018.day3;

public class Specification {

    private String id;

    private int spaceLeft;
    private int spaceTop;
    private int width;
    private int height;

    public Specification(String id, int spaceLeft, int spaceTop, int width, int height) {
        this.id = id;
        this.spaceLeft = spaceLeft;
        this.spaceTop = spaceTop;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSpaceLeft() {
        return spaceLeft;
    }

    public void setSpaceLeft(int spaceLeft) {
        this.spaceLeft = spaceLeft;
    }

    public int getSpaceTop() {
        return spaceTop;
    }

    public void setSpaceTop(int spaceTop) {
        this.spaceTop = spaceTop;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
