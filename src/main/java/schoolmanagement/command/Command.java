package schoolmanagement.command;

import java.util.Map;

public class Command {

    private final Behavior behavior;
    private final Target target;
    private Map<String,String> keyword;

    public Command(Behavior behavior,Target target){
        this.behavior = behavior;
        this.target = target;
    };

    public Behavior getBehavior(){
        return behavior;
    }

    public Target getTarget(){
        return target;
    }

    public Map<String,String> getKeyword(){
        return keyword;
    }

    public void setKeyword(Map<String,String> map){
        keyword = map;
    }
}
