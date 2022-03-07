package schoolmanagement.command;

import org.apache.commons.collections4.MultiValuedMap;

import java.util.Map;

public class Command {

    private final Behavior behavior;
    private final Target target;
    private MultiValuedMap<String,String> keyword;

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

    public MultiValuedMap<String,String> getKeyword(){
        return keyword;
    }

    public void setKeyword(MultiValuedMap<String,String> map){
        keyword = map;
    }
}
