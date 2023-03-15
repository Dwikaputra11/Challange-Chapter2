package com.tutorial;

import java.util.List;

public class Classroom implements Calculation{
    private final String name;
    private final List<String> studentsGrade;

    public Classroom(String name, List<String> studentsGrade) {
        this.name = name;
        this.studentsGrade = studentsGrade;
    }

    public String generateClassTxt(){
        var str = "";

        str += "Nama Kelas: ".concat(name);
        str += "Rata-rata: ".concat(String.valueOf(getMean()));


        return str;
    }
    @Override
    public double getMean(){
        var value = 0.0;
        var count = studentsGrade.size();

        for(String str: studentsGrade){
            if(!str.equals(studentsGrade.get(0))){
                value += Double.parseDouble(str);
            }
        }
        return (count > 0) ? value/count : 0;
    }

    @Override
    public int getModus(){
        var max = 0;
        var tempGrade = studentsGrade.get(0);
        var gradeModus = studentsGrade.get(0);
        var gradeAppear = 0;

        for(String grade : studentsGrade){
            if(grade.equals(tempGrade)){
                gradeAppear++;
            }else{
                gradeAppear = 0;
                tempGrade = grade;
            }

            if(gradeAppear > max) {
                max = gradeAppear;
                gradeModus = tempGrade;
            }
        }

        return Integer.parseInt(gradeModus);
    }

    @Override
    public String getMedian() {
        int mid = studentsGrade.size()/2;
        return studentsGrade.get(mid);
    }

}
