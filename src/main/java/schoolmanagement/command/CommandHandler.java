package schoolmanagement.command;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class CommandHandler {

    private KeywordHandler keywordHandler;
    private static final String rgxForIdentifyTarget = "^[\s]*[1-5][^a-zA-Z0-9]*[a-zA-Z]+";

    //todo: need to initialize keywordHandler, or it will be initialized as null by default.Cause nullPointerException if you invoke functions with a null obj.
    public CommandHandler(){
        keywordHandler = new KeywordHandler();
    }

    public KeywordHandler getKeywordHandler() {
        return keywordHandler;
    }

    public Command parseCommand(String commandText){

        if(!commandText.substring(0,1).matches("[1-5]")){
            return null;
        }
        Behavior behavior =  Behavior.getByIndex(Integer.valueOf(commandText.substring(0,1)));
        Target target = Target.getByDescription(findByRegex(commandText));
        Command command = new Command(behavior,target);
        command.setKeyword(this.keywordHandler.parseKeyword(commandText));
        return command;
    }

    private String findByRegex(String text){
        Pattern p = Pattern.compile(rgxForIdentifyTarget);
        Matcher m = p.matcher(text);
        String result = null;
        while (m.find()){
            result = m.group();
        }
        if(result==null){
            return null;
        }
        Pattern p_2 = Pattern.compile("[a-zA-Z]+");
        Matcher m_2 = p_2.matcher(result);
        while(m_2.find()){
            result = m_2.group();
        }
        return result;
    }

//    public Command parseCommandFromFile(Stream k, File file){
//
//        Behavior behavior =  Behavior.getByIndex(1);
//        Target target = Target.getByDescription(findByFileName(file));
//        Command command = new Command(behavior,target);
//        command.setKeyword(this.keywordHandler.parseKeyword(k.toString()));
//        return command;
//    }



}
