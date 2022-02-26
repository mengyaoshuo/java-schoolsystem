package schoolmanagement;

import schoolmanagement.command.*;
import schoolmanagement.managers.*;

import java.io.File;
import java.util.*;

public class Main {

    static boolean flag = true;
    static Scanner scan = new Scanner(System.in);
    static final File directoryPath = new File("/Users/yao.meng/gitRepo/SchoolSystem/SchoolSystem");

    public static void main(String[] args) {

        MyFileReader.createFileDirectory(directoryPath.listFiles());

        Manager teacherM = new TeacherManager();
        Manager studentM = new StudentManager();
        Manager myclassM = new MyclassManager();
        CommandHandler commandHandler = new CommandHandler();

        Map<Target, Manager> managers = new HashMap<>();
        managers.put(Target.TEACHER, teacherM);
        managers.put(Target.STUDENT, studentM);
        managers.put(Target.CLASS, myclassM);

        while (flag) {

            System.out.println("Features : 1.add\t2.delete\t3.search\t4.change\t5.listAll\n" +
                    "Input format : \"1.teacher name=wang subject=maths\" or \"3.class name=classsix teacher=wang student=li,xiao,han\" ");

            Command command = commandHandler.parseCommand(scan.nextLine().trim());
            managers.get(command.getTarget()).conduct(command.getBehavior(), command.getKeyword());
            String answer = scan.nextLine();
            judgeAnswer(answer);
        }
    }
    static void judgeAnswer(String answer){
        if (answer.equalsIgnoreCase("exit")) {
            flag = false;
        } else if (answer.equalsIgnoreCase("continue")) {
            flag = true;
        } else {
            System.out.println("Unsupported character. Please input continue or exit!");
            String newAnswer = scan.nextLine();
            judgeAnswer(newAnswer);
        }
    }
}
