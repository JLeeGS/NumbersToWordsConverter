package com.genspark.NumbersToWordsConverter.service;

import com.genspark.NumbersToWordsConverter.domain.NumberObj;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UseFile {

    public ArrayList<String> readNumbers(String path){
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
        double numEle = Math.ceil((double) numbers.size() / cols);
        int numElementsInFullCol = (int) numEle;
        int numberOfFullCols = numbers.size() / numElementsInFullCol;
        boolean areLeftovers = numbers.size() % numElementsInFullCol != 0;
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
            int numNeeded = numElementsInFullCol - numLeftOver;
            for(int l = 0; l < numNeeded; l++){
                leftOvers.add(new NumberObj(0, ""));
            }
            columList.add(leftOvers);
        }
        return columList;
    }

    public ArrayList<ArrayList<NumberObj>> format2(int cols, ArrayList<NumberObj> numbers){
        ArrayList<ArrayList<NumberObj>> result = new ArrayList<>();
        int numRows = (int) Math.ceil(numbers.size() / cols);
        for(int i = 0; i < numRows; i++){
            ArrayList<NumberObj> row = new ArrayList<NumberObj>();
            for(int j = 0; j < cols; j++){
                row.add(numbers.get(i + (numRows * j)));
            }
            result.add(row);
        }
        return result;
    }

    public void display(ArrayList<ArrayList<NumberObj>> numbersArray){
            int fullSize = numbersArray.get(0).size();
            for (int i = 0; i < fullSize; i++) {
                for (int j = 0; j < numbersArray.size(); j++) {
                    System.out.printf("%-20s",numbersArray.get(j).get(i).getName());
                }
                System.out.println();
            }
    }

    public void display2(ArrayList<ArrayList<NumberObj>> numbersArray){
        int fullSize = numbersArray.get(0).size();
        for (int i = 0; i < fullSize; i++) {
            System.out.println(numbersArray);
            for (int j = 0; j < numbersArray.size(); j++) {
                //System.out.printf("%-20s",numbersArray.get(j).get(i).getName());
            }
        }
    }

    public void determineColumns(ArrayList<String> file){
        int col=file.size();
    }

    public int getUserInput(){
        Scanner scan=new Scanner(System.in);
        int col=0;
        System.out.println("Type in desired column Number: ");
        try {
            col=Integer.parseInt(scan.nextLine());
        }
        catch (Exception e){//userinput
        }
        return col;
    }
}
