package com.genspark.NumbersToWordsConverter;

import com.genspark.NumbersToWordsConverter.domain.Number;
import com.genspark.NumbersToWordsConverter.domain.NumberSet;
import com.genspark.NumbersToWordsConverter.service.Converter;
import com.genspark.NumbersToWordsConverter.service.UseFile;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class NumbersToWordsConverterApplicationTests {

	@BeforeEach
	void setUp(){
		System.out.println("Starting Test");
	}

	@Test
	void getNumber() {
		Converter con=new Converter();
		assertEquals(con.getNumber("Thirty Nine").getIndex(),39);
		assertEquals(con.getNumber("Forty Five").getName(), "Forty Five");
		System.out.println(con.getNumber("Seventy Three"));
	}

	@Test
	void getNumberFromSet(){
		NumberSet set=new NumberSet();
		System.out.println(set.getNumberByListAndName(set.getNumsByTens(),"Thirty"));
	}

	@Test
	void getStreamList(){
		NumberSet set=new NumberSet();
		List<Number> list=set.getNumsOneToNineteen(); String name="Ten";
		System.out.println(list.stream().filter(x->x.getName().equals(name)).findFirst().get());
	}

	@Test
	void getNumbersFromArrayList(){
		Converter con=new Converter(); NumberSet set=new NumberSet();ArrayList<Number> allNums=new ArrayList<>();
		ArrayList<String> test=new ArrayList<>(Arrays.asList("One", "Three", "Thirteen", "Fifteen", "Ten"));
		test.stream().forEach(x->System.out.println(set.getNumberByListAndName(set.getNumsOneToNineteen(),x)));
	}

	@Test
	void getAllNumbers(){
		Converter con=new Converter();ArrayList<Number> allNums=new ArrayList<>();
		ArrayList<String> test=new ArrayList<>(Arrays.asList("One", "Three", "Thirteen", "Fifteen", "Thirty One", "Fifty Two", "Twenty Nine"));
		test.forEach(x->allNums.add(con.getNumber(x)));
		Collections.sort(allNums);
		System.out.println(allNums);
	}

	@Test
	void getNumberFromFile(){
		UseFile useFile=new UseFile();
		useFile.readNumbers("");
	}

	@AfterEach
	void tearDown(){
		System.out.println("Tests Complete");
	}

}
