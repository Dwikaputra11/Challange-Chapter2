package com.tutorial;

import java.util.*;

public class School implements Calculation{
    private List<String> classesName;
    private final List<String> gradeByClass;
    private final Map<String, Integer> grades = new HashMap<>();

    public School(List<String> classesName, List<String> gradeByClass) {
        this.classesName    = classesName;
        this.gradeByClass   = gradeByClass;
        for(String i: gradeByClass){
            if(grades.containsKey(i)) grades.put(i, grades.get(i) + 1);
            else grades.put(i, 1);
        }
    }


    @Override
    public double getMean() {
        double value = 0.0;
        var count = gradeByClass.size();
        for(String i: gradeByClass){
            value += Double.parseDouble(i);
        }

        return value/count;
    }

    @Override
    public int getModus() {
        return Collections.max(grades.values());
    }

    @Override
    public String getMedian(){
        int mid = gradeByClass.size()/2;
        return gradeByClass.get(mid);
    }

    public String writeSchoolTxt(){
        StringBuilder str = new StringBuilder("Berikut Hasil Pengolahan Nilai\n\n");

        str.append("Nilai\t| Frekuensi");

        for (Map.Entry<String,Integer> entry : grades.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            str.append(key).append("\t| ").append(value);
        }

        str.append("Berikut hasil rekap nilai ujian sekolah\n\n");
        str.append("Mean: ").append(getMean());
        str.append("Modus: ").append(getModus());
        str.append("Median: ").append(getMedian());

        return str.toString();
    }



}
