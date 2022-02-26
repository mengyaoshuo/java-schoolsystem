package schoolmanagement;

import schoolmanagement.personnels.Personnel;
import schoolmanagement.personnels.Student;
import schoolmanagement.personnels.Teacher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileWriter {
    //write personnelList into files.if it's a class entry, then write it into class file.
//    public static void main(String[] args){
//        PersonnelManager per = new TeacherManager();
//        List<Personnel> testPersonnel = new ArrayList<>();
//        testPersonnel.add(new Teacher("wang","Chinese"));
//        testPersonnel.add(new Teacher("zhang","technology"));
//        writeToFiles(testPersonnel,per);
//    }

    public static void writeToFiles(Personnel per){
            PrintWriter out = null;
            try{
                out = new PrintWriter(new FileWriter(getFile(per),true));
                out.append("\n" + per + "\n");
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                out.close();
            }
    }

    private static File getFile(Personnel m){
        if(m instanceof Teacher){
            File log = new File("/Users/yao.meng/Documents/newTeacher.txt");
            return log;
        }else if(m instanceof Student){
            File log = new File("/Users/yao.meng/Documents/newStudent.txt");
            return log;
        }else{
            File log = new File("/Users/yao.meng/Documents/newClass.txt");
            return log;
        }
    }

//    static void removeItem(List<Personnel> per){
//        List<String> temp = new ArrayList<>();
//        for(File file : Main.filesList) {
//            try {
//                Stream<String> stream = Files.lines(Paths.get(file.toString()));
//                stream.forEach(line -> temp.add(line));
//                temp.removeIf(stream.filter(line -> per.contains(line)));
//
//
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }

}
