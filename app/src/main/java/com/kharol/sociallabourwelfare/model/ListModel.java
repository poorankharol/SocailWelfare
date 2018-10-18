package com.kharol.sociallabourwelfare.model;

public class ListModel {
    private String name;
    private String category;
    private String place;

    public ListModel(String name, String category, String place) {
        this.name = name;
        this.category = category;
        this.place = place;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPlace() {
        return this.place;
    }
}
