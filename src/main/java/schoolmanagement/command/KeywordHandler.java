package schoolmanagement.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class KeywordHandler {

    private MultiValuedMap<String,String> mapOfKeyword;
    private static final String rgxForSearchById = "([0-9]+,?)+";
    private static final String rgxForSearchByKeyValue = "([a-zA-Z]+=([a-zA-Z]+,?)+[\\s]?)+";


    public KeywordHandler(){
        mapOfKeyword = new ArrayListValuedHashMap<>();
    }

    //in this parseKeyword function, I standardize keyWord as Map where entries user wanted to extract are defined. So implementation of all the behaviors unified.
    public Map<String,String> parseKeyword(String commandText){

        if(! commandText.contains(" ")) {// condition: 5.teacher
            
            mapOfKeyword.put("id","all");//todo : not sure how to deal with this behavior

        }else {//3.teacher 058  或  3.teacher 057,064,94
            
            String keyword = commandText.substring(commandText.indexOf(" ") + 1);
            
            if(keyword.matches(rgxForSearchById)){
                
                mapOfKeyword.put("Id",keyword);

            }else if(keyword.matches(rgxForSearchByKeyValue)){//1.teacher name=wang subject=math  或  1.class name=classOne teacher=zhang student=liu,li,wang
                                                                // 或 1。teacher name=zhang,xiao
                String[] keywordArr = keyword.split("(\s)|(=)");

                for(int i = 0; i < keywordArr.length-1; i+=2){
                    if(!keywordArr[i+1].contains(",")){
                        mapOfKeyword.put(keywordArr[i],keywordArr[i+1]);
                    }else {
                        String[] temp = keywordArr[i + 1].split(",");
                        for(int j = 0;j < temp.length;j++){
                            mapOfKeyword.put(keywordArr[i],temp[j]);
                        }
                    }

                }

            }else {
                mapOfKeyword = null;
            }
        }
        return mapOfKeyword;
    }
}
