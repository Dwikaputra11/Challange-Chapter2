package com.tutorial;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String GRADE_FILE_PATH         = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.csv";
    private static final String SCHOOL_FILE_PATH        = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.txt";
    private static final String CLASS_FILE_PATH         = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_per_kelas.txt";
    private static final List<Classroom> classroomList  = new ArrayList<>();
    private static final List<String> className         = new ArrayList<>();
    private static final List<String> gradeByClass      = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readFile();
        // menu 1 tampilkan rekap nilai per kelas
        // menu 2 tampilkan rekap nilai sekolah
        // menu 3 keluar

        School school = new School(className, gradeByClass);
        writeFile(SCHOOL_FILE_PATH, school.writeSchoolTxt());

        var txt = new StringBuilder();
        txt.append("Berikut Rekap Nilai Setiap Kelas:\n\n");
        for(Classroom c: classroomList){
            txt.append(c.generateClassTxt());
        }
        txt.append("*n = banyak data\n");
        writeFile(CLASS_FILE_PATH, txt.toString());
    }

    private static void readFile() throws IOException {
        BufferedReader br = null;
        try {
            File file = new File(GRADE_FILE_PATH);
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            List<String> strArr = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                var list = List.of(line.split(";"));
                strArr.addAll(list);
                var name = strArr.get(0);
                className.add(name);
                strArr.remove(0);
                classroomList.add(new Classroom(name, strArr));
                gradeByClass.addAll(strArr);
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
