package com.practice.lambdas.refactor;

public class Artist {

    private String name;
    private String nationality;
    private int members;

    public Artist(String name, String nationality,int members)
    {
        this.name=name;
        this.nationality=nationality;
        this.members=members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }
}
