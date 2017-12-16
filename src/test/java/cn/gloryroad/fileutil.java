package cn.gloryroad;

import java.io.File;
import java.io.IOException;

public class fileutil {

    public static boolean createfile(String filename){
        File file=new File(filename);
        if (file.exists()){
            System.out.println("create"+filename+"failed,this file has existed!");
            return false;
        }
        if (filename.endsWith(File.separator)){
            System.out.println("create"+filename+"failed,this file can't be catalog!");
            return false;
        }
        if (!file.getParentFile().exists()){
            System.out.println("the dir of file is not exist,prepare create it!");
            if(!file.getParentFile().mkdir()){
                System.out.println("create dir failed!");
                return false;
            }
        }
        try {
            if (file.createNewFile()){
                System.out.println("create file"+filename+"succeed!");
                return true;
            }else {
                System.out.println("create file"+filename+"failed!");
                return false;
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("create file"+filename+"failed!"+e.getMessage());
            return false;
        }
    }
    public static boolean createdir(String dirname){
        File dir=new File(dirname);
        if (dir.exists()){
            System.out.println("create dir"+dirname+"failed,the dir has existed!");
            return false;
        }
        if (dir.mkdir()){
            System.out.println("create dir"+dirname+"succeed!");
            return true;
        }else {
            System.out.println("create dir"+dirname+"failed!");
            return false;
        }

    }

}
