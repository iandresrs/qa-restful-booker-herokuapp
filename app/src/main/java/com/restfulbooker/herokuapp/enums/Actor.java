package com.restfulbooker.herokuapp.enums;

public enum Actor {

    ACTOR("user");

    private String nameActor;

    private Actor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getNameActor() {
        return nameActor;
    }

}
