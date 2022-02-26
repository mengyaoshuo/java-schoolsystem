package schoolmanagement.managers;

import schoolmanagement.personnels.Student;
import schoolmanagement.personnels.Teacher;
import schoolmanagement.personnels.Myclass;
import schoolmanagement.personnels.Personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyclassManager extends Manager {

    private Map<Integer,Personnel> myclassMap = new HashMap<>();
    public List<Personnel> targetMyclassList = new ArrayList<>();

    public Map<Integer,Personnel> getMap(){
        return myclassMap;
    }

    public List<Personnel> getList(){
        return targetMyclassList;
    }


    public List<Personnel> getListByAttribute(String... keywordArr){
        switch (keywordArr[0]){
            case "teacher" :
                for(Personnel per : getMap().values()){
                    for(Personnel teacher : ((Myclass)per).getTeacherList()){
                        if(teacher.equals(keywordArr[1])){
                            targetMyclassList.add(per);
                        }
                    }
                }
                break;
            case "student" :
                for(Personnel per : getMap().values()){
                    for(Personnel student : ((Myclass)per).getStudentList()){
                        if(keywordArr[1].contains(student.toString())){
                            targetMyclassList.add(per);
                        }
                    }
                }
                break;
        }
        return targetMyclassList;

    }

    @Override
    protected Personnel createPersonnel(String... keyword) {
        Myclass classEntry = new Myclass(keyword[0]);
        classEntry.getTeacherList().add(new Teacher(keyword[1]));
        if(ifHasComma(keyword[2])){
            String[] temp = keyword[2].split(",");
            for(String str : temp){
                classEntry.getStudentList().add(new Student(str));
            }
        }else {
            classEntry.getStudentList().add(new Student(keyword[2]));
        }

        return classEntry;
    }

    private boolean ifHasComma(String temp){
        return temp.contains(",");
    }
}
