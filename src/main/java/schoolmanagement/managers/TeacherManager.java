package schoolmanagement.managers;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.AbstractListValuedMap;
import schoolmanagement.personnels.Personnel;
import schoolmanagement.personnels.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherManager extends BehaviorControllerManager {

    private Map<Integer,Personnel> teacherMap;
    private List<Personnel> targetTeacherList;

    private static TeacherManager teacherManager = new TeacherManager();

    private TeacherManager(){
        teacherMap = new HashMap<>();
        targetTeacherList = new ArrayList<>();
    }

    public static TeacherManager getInstance(){
        return teacherManager;
    }

    public Map<Integer,Personnel> getMap(){
        return teacherMap;
    }

    public List<Personnel> getList(){
        return targetTeacherList;
    }

    public List<Personnel> getListByAttribute(MultiValuedMap<String,String> keyword){

        for(String key : keyword.keySet()){

            switch (key){
                case "subject" :
                    for(String str : keyword.get(key)){
                        for(Personnel per : getMap().values()){
                            if(((Teacher)per).getSubject().equals(str)){
                                targetTeacherList.add(per);
                            }
                        }
                    }
                    break;
            }
        }
        return targetTeacherList;
    }

    protected void createPersonnel(MultiValuedMap<String,String> keyword){

        Teacher teacherEntry = new Teacher(keyword.get("name").iterator().next(),keyword.get("subject").iterator().next());
        teacherEntry.setId();
        teacherMap.put(teacherEntry.getId(),teacherEntry);
    }


}
