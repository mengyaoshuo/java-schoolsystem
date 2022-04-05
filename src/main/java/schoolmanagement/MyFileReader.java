package schoolmanagement;

import schoolmanagement.managers.BehaviorControllerManager;
import schoolmanagement.managers.MyclassManager;
import schoolmanagement.managers.StudentManager;
import schoolmanagement.managers.TeacherManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyFileReader {
//把文件读到内存就是把filepath包装成file对象。
//文件夹.listFiles()生成各文件file对象的数组。
//todo：把文件中每个entry new成command，conductAdd to add them in responding map.


    public static void createFileDirectory(final File[] filesList){
        for (File file : filesList) {
            try{
                Stream<String> stream = Files.lines(Paths.get(file.toString()));
                stream.forEach((k) ->{

                //1.把entries处理成输入模式。
                //2.调用main里的方法。
            });
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void readFile(File file, BehaviorControllerManager m){


    }
}
