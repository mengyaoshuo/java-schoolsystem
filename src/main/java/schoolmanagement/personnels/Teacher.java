package schoolmanagement.personnels;

import schoolmanagement.personnels.Personnel;

public class Teacher extends Personnel {

    private String subject;
    private static int counter;
    private int id;

    public Teacher(String name, String subject){
        super(name);
        this.subject = subject;
    }

    public Teacher(String name){
        super(name);
    }

    public void setId(){
        id = ++counter;
    }

    public String getSubject(){
        return this.subject;
    }

    public String toString(){
        return "Id:" + id + "\t" + "Name:" + name +"\t" +"Subject:" + subject;
    }
}
