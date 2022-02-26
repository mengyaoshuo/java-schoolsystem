package schoolmanagement.personnels;

import schoolmanagement.personnels.Personnel;

public class Student extends Personnel {

    private int age;
    private static int counter;
    private int id;

    public Student(String name, String age){
        super(name);
        this.age = Integer.parseInt(age);
    }

    public Student(String name){
        super(name);

    }

    public void setId(){
        id = counter++;
    }
    public int getAge(){
        return this.age;
    }

    public String toString(){
        return "Id:" + id + "\t" + "Name:" + name + "\t" +"Age:" + age;
    }
}
