package com.tutorial;

import java.io.*;
import java.util.ArrayList;

public class Main {

    private static final String path = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.csv";

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            String[] strArr;
            ArrayList<String> className = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                var value = 0;
                var count = 0;
                strArr = line.split(";");
                for (String str : strArr) {
                    if (strArr[0].equals(str)) {
                        className.add(str);
                    } else {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) br.close();
        }
    }

    public void write(String txtFile, String txt) throws IOException {
        BufferedWriter bwr = null;
        try {
            File file = new File(txtFile);
            if (file.createNewFile()) {
                System.out.println("new file is created");
            }
            FileWriter writer = new FileWriter(file);
            bwr = new BufferedWriter(writer);
            bwr.write(txt);
            bwr.newLine();
            bwr.flush();
            bwr.close();
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        } finally {
            if(bwr != null) bwr.close();
        }
    }
}
