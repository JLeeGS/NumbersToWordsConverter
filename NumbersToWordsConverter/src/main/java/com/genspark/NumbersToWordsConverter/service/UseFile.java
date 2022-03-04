package com.genspark.NumbersToWordsConverter.service;

import com.genspark.NumbersToWordsConverter.domain.NumberObj;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UseFile {

    public ArrayList<String> readNumbers(){
        String path="src/main/resources/numbersFile.txt";//temp path
        ArrayList<String> arrs=new ArrayList<>();
        try{
            File file=new File(path);
            Scanner scan= new Scanner(file);
            while(scan.hasNextLine()){
                arrs.add(scan.nextLine());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return arrs;
    }

    public ArrayList<ArrayList<NumberObj>> format(int cols, ArrayList<NumberObj> numbers){
        ArrayList<ArrayList<NumberObj>> columList = new ArrayList<>();
        int numElementsInFullCol = (int) Math.ceil(numbers.size() / cols);
        int numberOfFullCols = numbers.size() / numElementsInFullCol;
        boolean areLeftovers = numbers.size() % numElementsInFullCol == 0;
        for(int i = 0; i < numberOfFullCols; i++){
            ArrayList<NumberObj> column = new ArrayList<>();
            for(int j = 0; j < numElementsInFullCol; j++){
                column.add(numbers.get(j + (numElementsInFullCol * i)));
            }
            columList.add(column);
        }
        if(areLeftovers){
            ArrayList<NumberObj> leftOvers = new ArrayList<>();
            int numLeftOver = numbers.size() % numElementsInFullCol;
            for(int k = numbers.size() - numLeftOver; k < numbers.size(); k++){
                leftOvers.add(numbers.get(k));
            }
//            int numNeeded = numElementsInFullCol - numLeftOver;
//            for(int l = 0; l < numNeeded; l++){
//                leftOvers.add(new NumberObj(0, "Zero"));
//            }
//            columList.add(leftOvers);
        }
        return columList;
    }

    public void display(ArrayList<ArrayList<NumberObj>> numbersArray){
            int fullSize = numbersArray.get(0).size();
            for (int i = 0; i < fullSize; i++) {
                for (int j = 0; j < numbersArray.size(); j++) {
                    System.out.printf(centerString(10, numbersArray.get(j).get(i).getName()));
                }
                System.out.println();
            }
    }
    public String centerString(int width, String s){
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}
