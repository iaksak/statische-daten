package com.gefa.statischedaten.model;

/*
 * @created 20/09/2021 10:29 PM
 * @author Ivan Aksak aksak@iname.com
 */
public class Example {
    private String id;
    private String name;


    public Example() {
    }

    public Example(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
