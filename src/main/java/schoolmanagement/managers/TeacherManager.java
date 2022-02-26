package schoolmanagement.managers;

import schoolmanagement.personnels.Personnel;
import schoolmanagement.personnels.Student;
import schoolmanagement.personnels.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherManager extends Manager {

    private Map<Integer, Personnel> teacherMap = new HashMap<>();
    private List<Personnel> targetTeacherList = new ArrayList<>();

    public Map<Integer,Personnel> getMap(){
        return teacherMap;
    }

    public List<Personnel> getList(){
        return targetTeacherList;
    }

    public List<Personnel> getListByAttribute(Map<String,String> keyword){

        for(String key : keyword.keySet()){

            switch (key){
                case "subject" :
                    for(Personnel per : getMap().values()){
                        if(((Teacher)per).getSubject().equals(keyword.get(key))){
                            targetTeacherList.add(per);
                        }
                    }
                    break;
            }
        }
        return targetTeacherList;

    }


    protected void createPersonnel(String... keyword){
        Teacher teacherEntry = new Teacher(keyword[0],keyword[1]);
        teacherEntry.setId();
        teacherList.put(teacherEntry);
    }


}
