package schoolmanagement;


import schoolmanagement.managers.Manager;
import schoolmanagement.personnels.Personnel;

import java.util.List;
import java.util.Scanner;

public class RequestHandler {


//    int identifyFeather(String input){
//        int feather = Integer.valueOf(input.substring(0,1));
//        return feather;
//    }
//
//    String[] identifyObj(String input, String regex){
//        String[] object = findByRegex(input,regex).split("\\.");
//        return object;
//    }
//
//    String[] identifyKeyword(String input){
//        String[] temp = input.substring(input.indexOf(" ") + 1).split(" ");
//        return temp;
//    }

//    private String findByRegex(String input, String rgx){
//        Pattern p = Pattern.compile(rgx);
//        Matcher m = p.matcher(input);
//        String result = null;
//        while (m.find()){
//            result = m.group();
//        }
//        return result;
//    }

    public static void nameless(){

    }
    void conductAdd(Manager m, String... keyword)
    {
        List<Personnel> list = m.add(keyword);
    }
    void conductDelete(Manager m, String... keyword)
    {
        List<Personnel> list = m.delete(keyword);
        System.out.println("Input \"continue\" or \"exit \".");
    }
    void conductFind(Manager m, String... keyword)
    {
        m.find(keyword);
    }
    String preConduct(Manager m, String... keyword)
    {
        Scanner scan = new Scanner(System.in);
        if(!m.search(keyword)){
            System.out.println("Specific record doesn't exist. Please confirm!");
            System.out.println("Input \"continue\" or \"exit \".");
            String answer_4 = scan.nextLine();
            Main.judgeAnswer(answer_4);
        }else {
            System.out.println("Does this the one you want to change ? Please Input \"yes\" or \"no\".");
            m.print(Manager.targetPersonnelEntry);
            if(scan.nextLine().equalsIgnoreCase("yes")){
                conductDelete(m,keyword);
                System.out.println("Please input new record in the format of \"object attribute(s)\",and split each info with space.");
                String newKeyword = scan.nextLine();
                return newKeyword;

            }else{
                return null;
            }
        }
        return null;
    }
}
