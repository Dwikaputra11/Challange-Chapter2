package com.tutorial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String path = "D:\\Abied\\Code\\Binar-Challenge2\\res\\data_sekolah.csv";
    private static String pathNewFileDirectory = "D:\\Abied\\Code\\Binar-Challenge2\\res\\bykelas.txt";
    private static final List<Classroom> classroomList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder str = new StringBuilder();

        readFile();
        // menu 1 tampilkan rekap nilai per kelas
        for (Classroom cr: classroomList){
           str.append(cr.generateClassTxt());
           str.append("\n");
        }
        writeFile(pathNewFileDirectory, str.toString());

        // menu 2 tampilkan rekap nilai sekolah

        // menu 3 keluar
    }

    private static void readFile() throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            List<String> strArr = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                strArr.addAll(List.of(line.split(";")));
                var name = strArr.get(0);
                strArr.remove(0);
                classroomList.add(new Classroom(name, strArr));
                strArr.clear();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) br.close();
        }
    }

    public static void writeFile(String txtFile, String txt) throws IOException {
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
