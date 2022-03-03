package com.genspark.NumbersToWordsConverter.domain;

import java.util.*;

public class NumberSet {
    //numbers 1-19,//20-100...
    private List<Number> numsOneToNineteen, numsByTens;

    public ArrayList<Number> getNumsOneToNineteen(){
        ArrayList<Number> numList= new ArrayList<Number>(Arrays.asList(
                new Number(0, "Zero"), new Number(1, "One"), new Number(2, "Two"), new Number(3, "Three"),
                new Number(4, "Four"), new Number(5,  "Five"), new Number(6, "Six"), new Number(7, "Seven"),
                new Number(8, "Eight"), new Number(9, "Nine"),
                new Number(10, "Ten"), new Number(11, "Eleven"), new Number(12, "Twelve") , new Number(13, "Thirteen"),
                new Number(14, "Fourteen"), new Number(15, "Fifteen"), new Number(16, "Sixteen"), new Number(17, "Seventeen"),
                new Number(18, "Eighteen"), new Number(19, "Nineteen")
        ));
        return numList;
    }
    public ArrayList<Number> getNumsByTens(){
        ArrayList<Number> numList= new ArrayList<Number>(Arrays.asList(
                new Number(20, "Twenty"), new Number(30, "Thirty"), new Number(40, "Forty"), new Number(50, "Fifty"),
                new Number(60, "Sixty"), new Number(70,  "Seventy"), new Number(80, "Eighty"), new Number(90, "Ninety")
        ));
        return numList;
    }

    public ArrayList<Number> getNumsByHundreds(){
        ArrayList<Number> numList= new ArrayList<Number>(Arrays.asList(new Number(100, "Hundred"),
                new Number(1000, "Thousand"), new Number(1000000, "Million")));
        return numList;
    }


    public Number getNumberByListAndName(ArrayList<Number> list, String name){
        return list.stream().filter(x->x.getName().equals(name)).findFirst().get();
    }


}
