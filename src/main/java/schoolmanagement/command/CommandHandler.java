package schoolmanagement.command;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CommandHandler {

    private KeywordHandler keywordHandler;

    //todo: need to initialize keywordHandler, or it will be initialized as null by default.Cause nullPointerException if you invoke functions with a null obj.
    public CommandHandler(){
        keywordHandler = new KeywordHandler();
    }

    public KeywordHandler getKeywordHandler() {
        return keywordHandler;
    }

    public Command parseCommand(String commandText){

        Behavior behavior =  Behavior.getByIndex(Integer.valueOf(commandText.substring(0,1)));
        Target target = Target.getByDescription(findByRegex(commandText));
        Command command = new Command(behavior,target);
        command.setKeyword(this.keywordHandler.parseKeyword(commandText));
        return command;
    }
    //todo : invoke keywordhandler



    private String findByRegex(String text){
        Pattern p = Pattern.compile("\\.([a-zA-Z])+");
        Matcher m = p.matcher(text);
        String result = null;
        while (m.find()){
            result = m.group().substring(result.indexOf(".") + 1);
        }
        return result;
    }



}
