package schoolmanagement.managers;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import schoolmanagement.personnels.Student;
import schoolmanagement.personnels.Teacher;
import schoolmanagement.personnels.Myclass;
import schoolmanagement.personnels.Personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyclassManager extends BehaviorControllerManager {

    private Map<Integer,Personnel> myclassMap;
    private List<Personnel> targetMyclassList;
    private MultiValuedMap<String,String> mapForTeachers;
    private MultiValuedMap<String,String> mapForStudents;

    private static MyclassManager myclassManager = new MyclassManager();
    private MyclassManager(){
        myclassMap = new HashMap<>();
        targetMyclassList = new ArrayList<>();
        mapForTeachers = new ArrayListValuedHashMap<>();
        mapForStudents = new ArrayListValuedHashMap<>();
    }

    public static MyclassManager getInstance(){
        return myclassManager;
    }

    public Map<Integer,Personnel> getMap(){
        return myclassMap;
    }

    public List<Personnel> getList(){
        return targetMyclassList;
    }


    public List<Personnel> getListByAttribute(MultiValuedMap<String,String> keyword){

        for(String key : keyword.keySet()){

            switch (key){
                case "teacher" :
                    for(String str : keyword.get(key)){
                        for(Personnel per : getMap().values()){
                            for(Personnel perOfTeacher : ((Myclass)per).getTeacherList()){
                                if(perOfTeacher.toString().equals(str))  {//todo : toString()写法不对，要实现好toString()或者把list改成StringList
                                    targetMyclassList.add(perOfTeacher);
                                }
                            }
                        }
                    }
                    break;
                case "student" :
                    for(String str : keyword.get(key)){
                        for(Personnel per : getMap().values()){
                            for(Personnel perOfStudent : ((Myclass)per).getStudentList()){
                                if(perOfStudent.toString().equals(str))  {//todo : toString()写法不对，要实现好toString()或者把list改成StringList
                                    targetMyclassList.add(perOfStudent);
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return targetMyclassList;
    }
    @Override
    protected void createPersonnel(MultiValuedMap<String,String> keyword) {//1.class classone teacher wang student li,zhang,meng
        //search,return,print teacher entries.

        Myclass myclassEntry = new Myclass((keyword.get("name").iterator().next()));

        for(String name : keyword.get("teacher")){
            mapForTeachers.put("name",name);
            searchForAddingNewClass(mapForTeachers,TeacherManager.getInstance());
            myclassEntry.getTeacherList().add(new Teacher(name));
        }
        for(String name : keyword.get("student")){
            mapForStudents.put("name",name);
            searchForAddingNewClass(mapForStudents,StudentManager.getInstance());
            //create
            myclassEntry.getStudentList().add(new Teacher(name));
            //link
        }
    }

    private void searchForAddingNewClass(MultiValuedMap<String,String> map,TeacherManager m){
        m.search(map);
        new BehaviorResultDisplayManager().interactForDecideIfLink();
    }

    private void searchForAddingNewClass(MultiValuedMap<String,String> map,StudentManager m){
        m.search(map);
        new BehaviorResultDisplayManager().interactForDecideIfLink();
    }


}
