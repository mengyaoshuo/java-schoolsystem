package schoolmanagement.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class KeywordHandler {

    private MultiValuedMap<String,String> mapOfKeyword;
    private static final String rgxForSearchById = "([0-9]+,?)+";
    private static final String rgxForSearchByKeyValue = "([a-zA-Z]+[=]+([a-zA-Z1-9]+,?)+[\\s]?)+";
    private static final String rgxForDeleteSpaceAroundEqual = "[\\s]*[=]+[\\s]*";
    private static final String rgxForSplitKeyword = "([\s]+)|(=)";

    public KeywordHandler(){
        mapOfKeyword = new ArrayListValuedHashMap<>();
    }

    public MultiValuedMap<String,String> getMapOfKeyword(){
        return mapOfKeyword;
    }

    //in this parseKeyword function, I standardize keyWord as Map where entries user wanted to extract are defined. So implementation of all the behaviors unified.
    public MultiValuedMap<String,String> parseKeyword(String commandText){

        if(! commandText.contains(" ")) {// condition: 5.teacher//todo：not thoughtful for deal with listAll,need to use regex instead;
            
            mapOfKeyword.put("id","all");//todo : not sure how to deal with this behavior

        }else {//3.teacher 058  或  3.teacher 057,064,94
            
            String keyword = commandText.substring(commandText.indexOf(" ") + 1);
            
            if(keyword.matches(rgxForSearchById)){
                
                mapOfKeyword.put("Id",keyword);

            }else if(keyword.matches(rgxForSearchByKeyValue)){//1.class name = classOne teacher=zhang  student = liu,li,wang student =  wang,xiao"
                String newKeyword = keyword.replaceAll(rgxForDeleteSpaceAroundEqual,"=");
                String[] keywordArr = newKeyword.split(rgxForSplitKeyword);

                for(int i = 0; i < keywordArr.length-1; i+=2){
                    mapOfKeyword.put(keywordArr[i],keywordArr[i+1]);
                }
            }else {
                mapOfKeyword = null;
            }
        }
        return mapOfKeyword;
    }
}
