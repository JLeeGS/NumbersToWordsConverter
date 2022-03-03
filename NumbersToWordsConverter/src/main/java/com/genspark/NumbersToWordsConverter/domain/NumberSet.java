package com.genspark.NumbersToWordsConverter.domain;

import java.util.*;

public class NumberSet {
    //numbers 1-19,//20-100...
    private List<NumberObj> numsOneToNineteen, numsByTens;

    public ArrayList<NumberObj> getNumsOneToNineteen(){
        ArrayList<NumberObj> numList= new ArrayList<NumberObj>(Arrays.asList(
                new NumberObj(0, "Zero"), new NumberObj(1, "One"), new NumberObj(2, "Two"), new NumberObj(3, "Three"),
                new NumberObj(4, "Four"), new NumberObj(5,  "Five"), new NumberObj(6, "Six"), new NumberObj(7, "Seven"),
                new NumberObj(8, "Eight"), new NumberObj(9, "Nine"),
                new NumberObj(10, "Ten"), new NumberObj(11, "Eleven"), new NumberObj(12, "Twelve") , new NumberObj(13, "Thirteen"),
                new NumberObj(14, "Fourteen"), new NumberObj(15, "Fifteen"), new NumberObj(16, "Sixteen"), new NumberObj(17, "Seventeen"),
                new NumberObj(18, "Eighteen"), new NumberObj(19, "Nineteen")
        ));
        numList.addAll(getNumsByTens());
        return numList;
    }
    public ArrayList<NumberObj> getNumsByTens(){
        ArrayList<NumberObj> numList= new ArrayList<NumberObj>(Arrays.asList(
                new NumberObj(20, "Twenty"), new NumberObj(30, "Thirty"), new NumberObj(40, "Forty"), new NumberObj(50, "Fifty"),
                new NumberObj(60, "Sixty"), new NumberObj(70,  "Seventy"), new NumberObj(80, "Eighty"), new NumberObj(90, "Ninety")
        ));
        return numList;
    }

    public ArrayList<NumberObj> getNumsByHundreds(){
        ArrayList<NumberObj> numList= new ArrayList<NumberObj>(Arrays.asList(new NumberObj(100, "Hundred"),
                new NumberObj(1000, "Thousand"), new NumberObj(1000000, "Million")));
        return numList;
    }


    public NumberObj getNumberByListAndName(ArrayList<NumberObj> list, String name){
        try{
           return list.stream().filter(x->x.getName().equals(name)).findFirst().get();
        }
        catch(Exception e){
            System.out.println(name);
           return new NumberObj(0,"Zero");
        }
    }


}
