package com.tutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private final static String path = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.csv";

    public static void main(String[] args) {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] strArr;
            ArrayList<String> className = new ArrayList<>();

            while ((line = br.readLine()) != null){
                var value = 0;
                var count = 0;
                strArr = line.split(";");
                for(String str: strArr){
                    if(strArr[0].equals(str)){
                        className.add(str);
                    }else{
                        System.out.print(str + " ");
                        value += Integer.parseInt(str);
                        count++;
                    }
                }
                System.out.println("\nvalue: " + value);
                System.out.println("count: " + count);
            }

            System.out.println("Kelas: " + className);
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
