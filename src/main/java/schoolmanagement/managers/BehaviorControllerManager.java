package schoolmanagement.managers;

import org.apache.commons.collections4.MultiValuedMap;
import schoolmanagement.MyFileWriter;
import schoolmanagement.command.Target;
import schoolmanagement.personnels.Personnel;
import schoolmanagement.command.Behavior;

import java.util.*;

public abstract class BehaviorControllerManager {
    //todo:? 静态变量还需要getter setter么？
    public static Map<Target, BehaviorControllerManager> managers = new HashMap<>();

    public abstract Map<Integer,Personnel> getMap();

    public abstract List<Personnel> getList();

    public abstract List<Personnel> getListByAttribute(MultiValuedMap<String,String> keywordArr);

    public void conduct(Behavior behavior, MultiValuedMap<String,String> keyword){

        BehaviorResultDisplayManager display = new BehaviorResultDisplayManager();
        switch (behavior){

            case ADD -> add(keyword);
            case DELETE -> delete(keyword);
            case SEARCH -> search(keyword);
            // list of targetEntries has been returned.
//            case CHANGE -> change(keyword);// todo : change
//            case LIST_ALL -> getList(keyword);// todo : need change
        }
        display.printSuccessfulMessage();
    }

    void search(MultiValuedMap<String,String> keyword) {

        BehaviorResultDisplayManager managerView = new BehaviorResultDisplayManager();

        managerView.print(getListByAttribute(keyword));
        getMap().clear();

    }

    void add(MultiValuedMap<String,String> keyword){//1.teacher

        if(keyword == null){}//todo : deal it in main?
        createPersonnel(keyword);
    }

    protected abstract void createPersonnel(MultiValuedMap<String,String> keyword);

    void delete(MultiValuedMap<String,String> keyword){

        search(keyword);
        this.getMap().remove(getList().get(0).getId());

    }

//    void change(MultiValuedMap<String,String> keyword){
//
//        new BehaviorResultDisplayManager().interactForChange(search(keyword));
//        //todo:add new
//    }

}

