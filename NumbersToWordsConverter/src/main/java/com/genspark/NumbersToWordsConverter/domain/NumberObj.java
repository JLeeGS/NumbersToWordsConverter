package com.genspark.NumbersToWordsConverter.domain;


public class NumberObj implements Comparable<NumberObj> {
    private int index;
    private String name;

    public NumberObj(){
        super();
    }
    public NumberObj(int index, String name){
        this.index=index;
        this.name=name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(NumberObj n) {
        int compareIndex=((NumberObj) n).getIndex();
        return this.getIndex()-compareIndex; //ascending
    }
    @Override
    public String toString(){
        return getIndex()+" "+getName();
    }
}
