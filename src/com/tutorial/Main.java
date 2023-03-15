package com.tutorial;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {

    private static final String path = "C:\\dev\\Java\\Binar Academy\\Git Config\\Challange-Chapter2\\res\\data_sekolah.csv";

    public static void main(String[] args) throws IOException {
        menu();

//        BufferedReader br = null;
//        try {
//            File file = new File(path);
//            FileReader fr = new FileReader(file);
//            br = new BufferedReader(fr);
//            String line;
//            String[] strArr;
//            ArrayList<String> className = new ArrayList<>();
//
//            while ((line = br.readLine()) != null) {
//                var value = 0;
//                var count = 0;
//                strArr = line.split(";");
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
//            }
//
//            System.out.println("Kelas: " + className);
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(br != null) br.close();
//        }
//    }
//
//    public void write(String txtFile, String txt) throws IOException {
//        BufferedWriter bwr = null;
//        try {
//            File file = new File(txtFile);
//            if (file.createNewFile()) {
//                System.out.println("new file is created");
//            }
//            FileWriter writer = new FileWriter(file);
//            bwr = new BufferedWriter(writer);
//            bwr.write(txt);
//            bwr.newLine();
//            bwr.flush();
//            bwr.close();
//        } catch (IOException e) {
//            System.out.println("An error occured");
//            e.printStackTrace();
//        } finally {
//            if(bwr != null) bwr.close();
//        }
    }


        public static void menu(){
            Scanner scan = new Scanner(System.in);
            int choose;
            boolean kondisi = false;
            int pilih;
            do {
                System.out.println("-------------------------------");
                System.out.println("Aplikasi Pengolah Nilai Siswa");
                System.out.println("-------------------------------");
                System.out.println("File telah digenerate");
                System.out.println("Pilih Menu");
                System.out.println("1. Generate txt Untuk Menampilkan Nilai Kelas");
                System.out.println("2. Generate txt Untuk Menampilkan Nilai Sekolah");
                System.out.println("0. Exit");
                System.out.print("Tentukan Pilihan : ");
                choose = scan.nextInt();
                switch (choose){
                    case 1 :
                        System.out.println("-------------------------------");
                        System.out.println("Aplikasi Pengolah Nilai Siswa");
                        System.out.println("-------------------------------");
                        System.out.println("Generate txt untuk menampilkan nilai kelas sudah selesai");
                        System.out.println("File telah di generate di \nsilahkan dicek");
                        System.out.println("-------------------------------");
                        System.out.println("0. Exit\n1. Kembali ke menu utama");
                        System.out.print("Silahkan Pilih : ");
                        pilih = scan.nextInt();
                        if(pilih == 1){
                            kondisi = true;
                        }else{
                            kondisi = false;
                        }
                        break;
                    case 2:
                        System.out.println("-------------------------------");
                        System.out.println("Aplikasi Pengolah Nilai Siswa");
                        System.out.println("-------------------------------");
                        System.out.println("Generate txt untuk menampilkan nilai semua sekolah sudah selesai");
                        System.out.println("File telah di generate di \nsilahkan dicek");
                        System.out.println("-------------------------------");
                        System.out.println("0. Exit\n1. Kembali ke menu utama");
                        System.out.print("Silahkan Pilih : ");
                        pilih = scan.nextInt();
                        if(pilih == 1){
                            kondisi = true;
                        }else{
                            kondisi = false;
                        }
                        break;
                    case 0:
                        kondisi = true;
                    default:
                        System.out.println("Pilihan Tidak Ada");
                }
            }while(kondisi);

    }
}
