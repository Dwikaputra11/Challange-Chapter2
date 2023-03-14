package com.tutorial;

public class Classroom {
    private String name;
    private String[] studentsGrade;

    public Classroom(String name, String[] studentsGrade) {
        this.name = name;
        this.studentsGrade = studentsGrade;
    }

    public String generateClassTxt(){
        var str = "";

        str += "Nama Kelas: ".concat(name);
        str += "Rata-rata: ".concat(String.valueOf(getMean()));


        return str;
    }

    public double getMean(){
        var value = 0.0;
        var count = 0.0;

        for(String str: studentsGrade){
            if(!str.equals(studentsGrade[0])){
                value += Double.parseDouble(str);
                count++;
            }
        }
        return value/count;
    }

    public double getModus(){
        var value = 0.0;
        var count = 0.0;

        for(String str: studentsGrade){
            if(!str.equals(studentsGrade[0])){
                value += Double.parseDouble(str);
                count++;
            }
        }
        return value/count;
    }

}
