package com.genspark.NumbersToWordsConverter.service;

import com.genspark.NumbersToWordsConverter.domain.NumberObj;
import com.genspark.NumbersToWordsConverter.domain.NumberSet;

import java.util.ArrayList;
import java.util.Collections;

public class Converter {
    public ArrayList<String> sorted=new ArrayList<>();
    public void getNumberType(){
        //break down number...

        //Twenty One.. has space
        //Twenty +" "+One
        //By Tens+" "+<10 //add
    }

    public NumberObj getNumber(String num){
        NumberSet numSet=new NumberSet(); NumberObj getNum=null;
        ArrayList<NumberObj> sorted=new ArrayList<>();
        numSet.getNumsOneToNineteen().stream().forEach(x->{
            if(num.contains(" ")){
                String[] split=num.split(" ");
                sorted.add(new NumberObj(numSet.getNumberByListAndName(numSet.getNumsByTens(),split[0]).getIndex()+
                        numSet.getNumberByListAndName(numSet.getNumsOneToNineteen(),split[1]).getIndex(),
                        split[0]+" "+split[1])); //Add Double Digits
            }
            else if(x.getName().equals(num)) {  //Add Single Digits
                sorted.add(new NumberObj(x.getIndex(),x.getName()));
            }
        });
        return sorted.get(0);
    }

    public ArrayList<NumberObj> getNumbersFromArrayList(ArrayList<String> numbers){
        ArrayList<NumberObj> allNums=new ArrayList<>();Converter con=new Converter();
        numbers.forEach(x->allNums.add(con.getNumber(x)));
        Collections.sort(allNums);
        return allNums;
    }

    public int getHundreds(String num){
        NumberSet set=new NumberSet();
        int spaces = (int) num.chars().filter(n -> n == (int)' ').count();
        String[] split=num.split(" ");int count=0;
        for(int i =0; i<=spaces; i++) {
            NumberObj n=set.getNumberByListAndName(set.getNumsByHundreds(), split[i]);
            if(n.getIndex()!=0) {
                count++;
            }
        }
        return count;
    }

    public NumberObj hundredsLoop(String num){
        NumberSet numSet= new NumberSet(); NumberObj getNum=null; String[] split=num.split(" ");
        int spaces = (int) num.chars().filter(n -> n == (int)' ').count(); ArrayList<NumberObj> sorted=new ArrayList<>();
        numSet.getNumsOneToNineteen().stream().forEach(x->{
            for(int i=0; i<getHundreds(num); i++) {
                if (x.getName()!=split[i]) {
                    sorted.add(new NumberObj(numSet.getNumberByListAndName(numSet.getNumsOneToNineteen(), split[0]).getIndex() *
                            numSet.getNumberByListAndName(numSet.getNumsByHundreds(), split[1]).getIndex(),
                            split[0] + " " + split[1]));
                }
                else{  //Add Single Digits
                    sorted.add(new NumberObj(x.getIndex(),x.getName()));
                }
            }
        });
        return sorted.get(0);
    }
}
