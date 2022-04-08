package schoolmanagement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import schoolmanagement.managers.BehaviorControllerManager;
import schoolmanagement.personnels.Personnel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MyFileReader {
//把文件读到内存就是把filepath包装成file对象。
//文件夹.listFiles()生成各文件file对象的数组。
//todo：把文件中每个entry new成command，conductAdd to add them in responding map.

    private MyFileReader() {};

    public static void readAsMap(final File[] filesList){

        for (File file : filesList) {
            StringBuilder sb = new StringBuilder();
            try{
                Stream<String> stream = Files.lines(Paths.get(file.toString()));
                stream.forEach((k) ->{
                    sb.append(k);
            });
            }catch(IOException e){
                e.printStackTrace();
            }
            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
            parseMapToSchoolKeyConcept(jsonObject);
        }
    }

    //new 对象并加入map？
    public static void parseMapToSchoolKeyConcept(JSONObject json){

        for(int i = 0;i < json.getJSONArray("teachers").size();i++){
            JSONObject jsonObject = JSONObject.parseObject((String) json.getJSONArray("teachers").get(i));

        }
    }


    public static void readFile(File file, BehaviorControllerManager m){


    }
}
