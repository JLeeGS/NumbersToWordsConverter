package com.genspark.NumbersToWordsConverter.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UseFile {

    public ArrayList<String> readNumbers(String path){
        path="src/main/resources/numbers.txt";//temp path
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

    public void display(int col){

    }
}
