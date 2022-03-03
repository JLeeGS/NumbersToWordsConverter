package com.genspark.NumbersToWordsConverter.driver;

import com.genspark.NumbersToWordsConverter.domain.NumberSet;
import com.genspark.NumbersToWordsConverter.service.Converter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class NumbersToWordsConverterApplication {

	public static void main(String[] args) {
		NumberSet set=new NumberSet();
		Converter con=new Converter();
		ArrayList<String> test=new ArrayList<>(Arrays.asList("One", "Three", "Thirteen", "Fifteen", "Ten", "Thirty One", "Fifty Two", "Twenty Nine"));
		System.out.println(con.getNumbersFromArrayList(test));
	}

}
