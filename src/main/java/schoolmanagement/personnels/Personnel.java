package schoolmanagement.personnels;

public abstract class Personnel {

    protected String name;

    public Personnel(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public abstract int getId();

    public abstract String toString();
}
