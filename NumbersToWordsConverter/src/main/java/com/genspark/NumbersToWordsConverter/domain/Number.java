package com.genspark.NumbersToWordsConverter.domain;


public class Number implements Comparable<Number> {
    private int index;
    private String name;

    public Number(){
        super();
    }
    public Number(int index, String name){
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
    public int compareTo(Number n) {
        int compareIndex=((Number) n).getIndex();
        return this.getIndex()-compareIndex; //ascending
    }
    @Override
    public String toString(){
        return getIndex()+" "+getName();
    }
}
