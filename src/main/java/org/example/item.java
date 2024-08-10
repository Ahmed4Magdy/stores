package org.example;

public class item {
    private int IDitems;
    private String name;
    private int code;


    public item(String name, int code) {


        this.name = name;
        this.code = code;

    }

    public item() {

    }


    public void setIDitems(int IDitems) {
        this.IDitems = IDitems;
    }


    public int getIDitems() {
        return IDitems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
