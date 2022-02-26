package schoolmanagement.managers;

import schoolmanagement.MyFileWriter;
import schoolmanagement.personnels.Personnel;
import schoolmanagement.command.Behavior;

import java.util.*;

public abstract class Manager {

    public abstract Map<Integer,Personnel> getMap();

    public abstract List<Personnel> getList();

    public abstract List<Personnel> getListByAttribute(Map<String,String> keywordArr);

    public void conduct(Behavior behavior, Map<String,String> keyword){

        switch (behavior){

            case ADD -> add(keyword);
            case DELETE -> delete(keyword);
            case SEARCH -> search(keyword);// list of targetEntries has been returned.
            case CHANGE -> change(keyword);// todo : change
            case LIST_ALL -> getList(keyword);// todo : need change

        }
    }

    List<Personnel> search(Map<String,String> keyword) {

        if(keyword == null){} // todo : where am I supposed to deal with this null;

        getListByAttribute(keyword);

    }

//    private List<Personnel> searchByAttribute(String keyword){
//        String[] keywordArr = keyword.split("(\s)|(=)");// todo：keyword是复数attribute时一次判断多个条件拿到满足所有条件的entry.
//        // 先按照第一个条件找，找到放到targetlist里，再在targetList里按第二个条件找。
//        //要不要把keyword切开后直接存到map里，key-value就是【关键字-值】
//        //对于每一个key-value pair，第一对从map里拿出值存在targetlist里，之后每一次从targetlist里找值。或者一次就直接找到符合map里所有key-value的entry（这个实现更好）
//        if(keywordArr[0].equalsIgnoreCase("name")){
//            for(Personnel per : getMap().values()){
//                if(per.getName().equals(keywordArr[1])){
//                    getList().add(per);
//                }
//            }
//            return getList();
//        }else {
//            return getListByAttribute(keywordArr);
//        }
    }

    public List<Personnel> add(String keyword) {
        String[] keywordArr = keyword.split("=");
        for(int i = 0; i < keywordArr.length; i++){
            if()
        }
        if (search(keyword)) {
            System.out.print("Same record exists, please confirm :");
            print(targetPersonnelEntry);
            targetPersonnelEntry.clear();
            return null;
        } else {
            personnelList.add(createPersonnel(keyword));
            System.out.println("Your request conducted successfully.");
            MyFileWriter.writeToFiles(createPersonnel(keyword));
            return personnelList;
        }
    }

    protected abstract Personnel createPersonnel(String... keyword);

    public List<Personnel> delete(String... keyword) {
        if (!search(keyword)) {
            System.out.println("Specific record not found !");
            return null;
        } else {
            personnelList.removeAll(targetPersonnelEntry);
//            MyFileWriter.removeItem(targetPersonnelEntry);
            targetPersonnelEntry.clear();
            System.out.println("Your request conducted successfully.");
            return personnelList;
        }
    }

    public void find(String... keyword) {
        if (search(keyword)) {
            print(targetPersonnelEntry);
        } else {
            System.out.println("Specific records doesn't exist, please confirm !");
        }
        System.out.println("Input \"continue\" or \"exit \".");
    }

    public void listAll(Class per) {
        for(int i = 0;i<personnelList.size();i++){
            if(per.isInstance(personnelList.get(i))){
                targetPersonnelEntry.add(personnelList.get(i));
            }
        }
        print(targetPersonnelEntry);
        System.out.println("Input \"continue\" or \"exit \".");
        targetPersonnelEntry.clear();
    }

    void print(List<Personnel> list){
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            Personnel per = (Personnel) itr.next();
            System.out.println(per);
        }
    }

    void change(String... keyword) {


    }
}

