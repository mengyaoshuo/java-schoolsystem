package schoolmanagement.managers;

import schoolmanagement.managers.Manager;
import schoolmanagement.personnels.Personnel;
import schoolmanagement.personnels.Student;
import schoolmanagement.personnels.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager extends Manager {

    private Map<Integer,Personnel> studentMap = new HashMap<>();
    private List<Personnel> targetStudentList = new ArrayList<>();

    public Map<Integer,Personnel> getMap(){
        return studentMap;
    }

    public List<Personnel> getList(){
        return targetStudentList;
    }

    public List<Personnel> getListByAttribute(String... keywordArr){
        switch (keywordArr[0]){
            case "age" :
                for(Personnel per : getMap().values()){
                    if(((Student)per).getAge() == (Integer.parseInt(keywordArr[1]))){
                        targetStudentList.add(per);
                    }
                }
                break;
        }
        return targetStudentList;
    }
    protected Personnel createPersonnel(String... keyword){
        Student studentEntry = new Student(keyword[0],keyword[1]);
        studentEntry.setId();
        return studentEntry;
    }
}
