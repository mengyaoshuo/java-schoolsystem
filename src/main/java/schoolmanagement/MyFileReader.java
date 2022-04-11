package schoolmanagement;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MultiValuedMap;
import schoolmanagement.command.KeywordHandler;
import schoolmanagement.command.Target;

import java.io.File;//java.io package下的File类。
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

import static schoolmanagement.command.Behavior.ADD;
import static schoolmanagement.managers.BehaviorControllerManager.managers;

public class MyFileReader {
//把文件读到内存就是把filepath包装成file对象。
//文件夹.listFiles()生成各文件file对象的数组。
//todo：把文件中每个entry new成command，conductAdd to add them in responding map.

    private static MyFileReader myFileReader = new MyFileReader();

    public static MyFileReader getMyFileReader(){
        return myFileReader;
    }

    public void readFile(final File[] filesList){

        for (File file : filesList) {
            StringBuilder sb = new StringBuilder();
            try{
                Stream<String> stream = Files.lines(Paths.get(file.toString()));
                stream.forEach((k) ->{
                    sb.append(k); //我不会写两个：：的lambda方程式。

            });
                parseStringToJson(sb.toString());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void parseStringToJson(String str){
        JSONObject jsonObject = JSONObject.parseObject(str);
        String key = String.valueOf(jsonObject.keySet().iterator());
        addInitially(jsonObject,key);
    }

    private MultiValuedMap<String,String> parseJsonToMap(JSONObject json, String key){
        KeywordHandler temp = new KeywordHandler();
        for(int i = 0;i < json.getJSONArray(key).size();i++){
            JSONObject jsonObject = JSONObject.parseObject((String) json.getJSONArray(key).get(i));
            for(Iterator it = jsonObject.keySet().iterator(); it.hasNext();){
                temp.getMapOfKeyword().put((String) it.next(),jsonObject.getString((String) it.next()));
            }
        }
        return temp.getMapOfKeyword();
    }

    public void addInitially(JSONObject json,String key){
        managers.get(Target.getByDescription(key)).conduct(ADD,parseJsonToMap(json,key));

    }
}
