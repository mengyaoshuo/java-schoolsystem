package schoolmanagement;

import schoolmanagement.managers.Manager;
import schoolmanagement.managers.MyclassManager;
import schoolmanagement.managers.StudentManager;
import schoolmanagement.managers.TeacherManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyFileReader {

    public static void createFileDirectory(final File[] filesList){
        for (File file : filesList) {
            if (file.toString().contains("teacher")) {
                readFile(file, new TeacherManager());
            } else if (file.toString().contains("student")) {
                readFile(file, new StudentManager());
            } else if (file.toString().contains("class")) {
                readFile(file, new MyclassManager());
            }
        }
    }


    public static void readFile(File file, Manager m){

        RequestHandler requestHandler = new RequestHandler();
        try{
            Stream<String> stream = Files.lines(Paths.get(file.toString()));
            stream.forEach((k) ->{
                String[] keyword = k.substring(k.indexOf("\t") + 1).split("\t");
                requestHandler.conductAdd(m,keyword);
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
