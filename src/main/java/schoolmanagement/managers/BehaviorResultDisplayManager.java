package schoolmanagement.managers;

import org.apache.commons.collections4.MultiValuedMap;
import schoolmanagement.Main;
import schoolmanagement.personnels.Personnel;

import java.util.List;
import java.util.Scanner;

public class BehaviorResultDisplayManager {
    
    Scanner scanner;
    Boolean flag;
    
    public BehaviorResultDisplayManager(){
        scanner = new Scanner(System.in);
        flag = true;
    }

    public void interactWithUser(){
        while (flag) {
            //todo:make instruction more readable by using format.
            System.out.println("Available features and corresponding numbers: [1.add\t2.delete\t3.search\t4.change\t5.listAll].\n" +
                    "Available targets: [teacher\tstudent\tclass].\n" +
                    "Input format: ${1-5}.${target} ${attritubteKey}=${attributeValue} (multipule key-value pair and search by ID being supported)\n" +
                    "Input sample: Eg1.[1.teacher name=wang subject=maths] Eg2.[3.class name=classsX teacher=wang student=li,xiao,han] Eg3.[3.student 053,058]");

            Main.preConduct(scanner.nextLine());

        }
    }


    void print (List<Personnel> list){
        if(list.size() != 0){
            System.out.println("Search results are as follows.Please confirm :");
            for(Personnel per : list){
                System.out.println(per);
            }
        }else {
            System.out.println("No entry found. Please confirm.");
        }

    }

    void printSuccessfulMessage(){
        System.out.println("Your request is completed. Do you want to restart from beginning or exit?" +
                    "Input 'restart' or 'exit'.");
        judgeAnswer(scanner.nextLine());
    }

    void interactForDecideIfLink(){

        System.out.println("Above is existing teacher(s) with the same name, " +
                "do you want to link it with new adding class or create a new one? " +
                "Input 'link' for linking or 'create' for creating new entry.");
        judgeAnswer(scanner.nextLine());
    }

//    void interactForChange(List<Personnel> list){
//
//        if(list.size() == 1){
//            System.out.println("Do you want to change the above entry or exit? Input 'change' or 'exit'.");
//        }else {
//            System.out.println("Input Id to identify the entry you need to change.");
//
//            scanner.nextLine()
//        }
//
//    }

    void judgeAnswer(String answer){

        switch (answer.toLowerCase()){
            case "link" :

                break;
            case "create" :

                break;
            case "restart" :
                flag = false;
                break;
            case "exit" :
                flag = true;
                break;
            default:
                System.out.println("unsupported Charactor! Please input again!");
                judgeAnswer(scanner.nextLine());
        }
    }


}
