package schoolmanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//public class FileWriterTester {
//
//    public static void main(String[] args){
//        List<String> list = new ArrayList<>();
//        list.add("002\tTeacherZng\tmahs");
//        list.add("002\tTeacherZhanwu\tmahs");
////        try{
////            Files.write(Paths.get("/Users/yao.meng/SchoolSystem/testForFileWriter.txt"),list.toString().getBytes());
////        }catch (IOException e){
////            e.printStackTrace();
////        }
//        File log = new File("/Users/yao.meng/SchoolSystem/testForFileWriter.txt");
//        PrintWriter out = null;
//        try{
//            out = new PrintWriter(new FileWriter(log,true));
//            out.append("\n");
//            for(String str : list){
//                out.append(str + "\n"); //append String into PrintWriter
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            out.close();
//        }
//    }
//}
