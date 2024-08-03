package org.example;

public class store {

    private int IDstores;
    private String Name;
    private int code;

    public store( String Name, int code) {

        this.Name = Name;
        this.code = code;

    }

    public void setIDitems(int IDitems) {
        this.IDstores = IDitems;
    }

    public int getIDitems() {
        return IDstores;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
