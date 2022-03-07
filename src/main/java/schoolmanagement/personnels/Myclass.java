package schoolmanagement.personnels;

import schoolmanagement.personnels.Personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Myclass extends Personnel {

    private List<Personnel> teacher = new ArrayList<>();
    private List<Personnel> student = new ArrayList<>();
    private static int counter;
    private int id;

    public Myclass(String name) {
        super(name);
    }

    public void setId() {
        id = counter++;
    }

    public int getId(){ return this.id; }


    public List<Personnel> getTeacherList() {
        return teacher;
    }

    public List<Personnel> getStudentList() {
        return student;
    }

    public String toString(){
        return "Id:" + id + "\t" + "Name:" + this.name + "\t" + "Teacher:" + printMyclass(teacher) + "\t" + "Students:" + printMyclass(student);
    }
    private String printMyclass(List<Personnel> attribute){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<attribute.size();i++){
            stringBuilder.append(attribute.get(i).getName());
            if(i != (attribute.size()-1)){
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
