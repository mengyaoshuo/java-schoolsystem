package schoolmanagement.managers;

import schoolmanagement.personnels.Personnel;
import schoolmanagement.personnels.Student;
import org.apache.commons.collections4.MultiValuedMap;

import java.util.*;

public class StudentManager extends BehaviorControllerManager {

    private Map<Integer, Personnel> studentMap;
    private List<Personnel> targetStudentList;

    public StudentManager(){
        studentMap = new HashMap<>();
        targetStudentList = new ArrayList<>();
    }

    public Map<Integer, Personnel> getMap(){
        return studentMap;
    }

    public List<Personnel> getList(){
        return targetStudentList;
    }

    public List<Personnel> getListByAttribute(MultiValuedMap<String,String> keyword){
        for(String key : keyword.keySet()){

            switch (key){
                case "age" :
                    for(String str : keyword.get(key)){
                        for (Personnel per : getMap().values()){
                            if(((Student)per).getAge() == (Integer.parseInt(str))){
                                targetStudentList.add(per);
                            }
                        }
                    }
                    break;
            }
        }
        return targetStudentList;
    }
    protected void createPersonnel(MultiValuedMap<String,String> keyword){//想清楚问题 然后google。别人应该也遇到了，所以应该能google解决。

        Student studentEntry = new Student(keyword.get("name").iterator().next(),keyword.get("age").iterator().next());
        studentEntry.setId();
        studentMap.put(studentEntry.getId(),studentEntry);
    }
}
