package com.genspark.NumbersToWordsConverter.driver;

import com.genspark.NumbersToWordsConverter.domain.NumberSet;
import com.genspark.NumbersToWordsConverter.service.Converter;
import com.genspark.NumbersToWordsConverter.service.UseFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class NumbersToWordsConverterApplication {

	public static void main(String[] args) {
		Converter con=new Converter(); UseFile useFile=new UseFile();
		ArrayList<String> file=useFile.readNumbers();
		//System.out.println(useFile.format(2,con.getNumbersFromArrayList(file)));
		useFile.display(useFile.format(2,con.getNumbersFromArrayList(file)));
	}
}
