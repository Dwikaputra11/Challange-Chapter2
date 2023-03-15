package com.tutorial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String path = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.csv";
    private static String pathNewFileDirectory = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res";
    private static List<Classroom> classroomList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readFile();
        // menu 1 tampilkan rekap nilai per kelas
        // menu 2 tampilkan rekap nilai sekolah
        // menu 3 keluar
//        writeFile();
    }

    private static void readFile() throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            List<String> strArr = new ArrayList<>();
//            List<String> className = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                var value = 0;
                var count = 0;
                strArr.addAll(List.of(line.split(";")));
                var name = strArr.get(0);
                strArr.remove(0);

                classroomList.add(new Classroom(name, strArr));

//                for (String str : strArr) {
//                    if (strArr[0].equals(str)) {
//                        className.add(str);
//                    } else {
//                        System.out.print(str + " ");
//                        value += Integer.parseInt(str);
//                        count++;
//                    }
//                }

//                System.out.println("\nvalue: " + value);
//                System.out.println("count: " + count);
            }

//            System.out.println("Kelas: " + className);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) br.close();
        }
    }

    public void writeFile(String txtFile, String txt) throws IOException {
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
