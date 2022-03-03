package com.genspark.NumbersToWordsConverter.service;

import com.genspark.NumbersToWordsConverter.domain.Number;
import com.genspark.NumbersToWordsConverter.domain.NumberSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Converter {
    public ArrayList<String> sorted=new ArrayList<>();
    public void getNumberType(){
        //break down number...

        //Twenty One.. has space
        //Twenty +" "+One
        //By Tens+" "+<10 //add
    }

    public Number getNumber(String num){
        NumberSet numSet=new NumberSet(); Number getNum=null;
        ArrayList<Number> sorted=new ArrayList<>();
        int spaces = (int) num.chars().filter(n -> n == (int)' ').count();
        numSet.getNumsOneToNineteen().stream().forEach(x->{
            if(spaces==1){
                String[] split=num.split(" ");
                sorted.add(new Number(numSet.getNumberByListAndName(numSet.getNumsByTens(),split[0]).getIndex()+
                        numSet.getNumberByListAndName(numSet.getNumsOneToNineteen(),split[1]).getIndex(),
                        split[0]+" "+split[1]));
            }
            else if(x.getName().equals(num)) {
                sorted.add(new Number(x.getIndex(),x.getName()));
            }
        });
        return sorted.get(0);
    }
    public ArrayList<Number> getNumbersFromArrayList(ArrayList<String> numbers){
        Converter con=new Converter();ArrayList<Number> allNums=new ArrayList<>();
        numbers.forEach(x->allNums.add(con.getNumber(x)));
        Collections.sort(allNums);
        return allNums;
    }
}
