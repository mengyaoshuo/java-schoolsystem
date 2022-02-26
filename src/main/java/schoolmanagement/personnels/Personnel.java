package schoolmanagement.personnels;

import java.util.Map;

public abstract class Personnel {

    protected String name;

    public Personnel(String name){
        this.name = name;
    }

    abstract void setId();

    public String getName(){
        return this.name;
    }

    public abstract String toString();
}
