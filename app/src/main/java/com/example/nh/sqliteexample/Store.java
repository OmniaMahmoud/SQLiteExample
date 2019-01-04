package com.example.nh.sqliteexample;

public class Store {

    private int id;
    private String name;
    private String descreption;

    public Store(int id, String name, String descreption) {
        this.id = id;
        this.name = name;
        this.descreption = descreption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
