package schoolmanagement;

import schoolmanagement.command.*;
import schoolmanagement.managers.*;// need to import the package to use only public functions in it.

import java.io.File;

import static schoolmanagement.managers.BehaviorControllerManager.managers;

public class Main {
    //todo:how to use relative path?
    static final File directory = new File("/Users/yao.meng/Projects/schoolsystem/Doc");

    public static void main(String[] args) {

        MyFileReader.getMyFileReader().readFile(directory.listFiles());

        System.out.println("Hello, and welcome!" +
                "Please confirm the manual below to make full use of this super functional \"Princess Meng\" SchoolManament System.\n");
        new BehaviorResultDisplayManager().interactWithUser();
        //todo:write changes to file by overwrite files with maps.
        System.out.println("Thanks for using \"Princess Meng\". Hope you have a nice day!");
    }

    private static void fillInMapOfManagers () {

        managers.put(Target.TEACHER, TeacherManager.getInstance());
        managers.put(Target.STUDENT, StudentManager.getInstance());
        managers.put(Target.CLASS, MyclassManager.getInstance());
    }

    public static void preConduct (String input) {
        CommandHandler commandHandler = new CommandHandler();
        Command command = commandHandler.parseCommand(input.trim());

        if (command == null) {
            System.out.println("Unsupported Feature." +
                        "Features should be added in the beginning with digit numbers of 1,2,3,4 or 5. Please input again.");
            return;
        }
        if (command.getTarget() == null) {
            //wrong cases: 1.5.teacher or 1.taecher
            System.out.println("Unsupported target." +
                        "Target should be 'teacher','student' or 'class' and behind number of 1-5 only.Please input again.");
            return;
        }
        if (command.getKeyword() == null) {
            System.out.println("Unsupported keyword." +
                        "keyword should be either pure numbers or key-value pairs connected with '='.Please input again.");
            return;
        }
        fillInMapOfManagers();//为什么写成静态方法后，managers map就每次更新了？
        managers.get(command.getTarget()).conduct(command.getBehavior(), command.getKeyword());
    }
}
