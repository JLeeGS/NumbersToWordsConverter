package com.genspark.NumbersToWordsConverter;

import com.genspark.NumbersToWordsConverter.domain.NumberObj;
import com.genspark.NumbersToWordsConverter.domain.NumberSet;
import com.genspark.NumbersToWordsConverter.service.Converter;
import com.genspark.NumbersToWordsConverter.service.UseFile;
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
		System.out.println(set.getNumberByListAndName(set.getNumsByTens(),"Twenty"));
	}

	@Test
	void getStreamList(){
		NumberSet set=new NumberSet();
		List<NumberObj> list=set.getNumsOneToNineteen(); String name="Ten";
		System.out.println(list.stream().filter(x->x.getName().equals(name)).findFirst().get());
	}

	@Test
	void getNumbersFromArrayList(){
		Converter con=new Converter(); NumberSet set=new NumberSet();ArrayList<NumberObj> allNums=new ArrayList<>();
		ArrayList<String> test=new ArrayList<>(Arrays.asList("Nineteen", "Thirteen", "Fifteen", "Ten"));
		test.stream().forEach(x->System.out.println(set.getNumberByListAndName(set.getNumsOneToNineteen(),x)));
	}

	@Test
	void getAllNumbers(){
		Converter con=new Converter();ArrayList<NumberObj> allNums=new ArrayList<>();
		ArrayList<String> test=new ArrayList<>(Arrays.asList("Thirty Five", "Three", "Thirteen", "Fifteen", "Thirty One", "Fifty Two", "Twenty Nine"));
		test.forEach(x->allNums.add(con.getNumber(x)));
		Collections.sort(allNums);
		System.out.println(allNums);
	}

	@Test
	void numHasHundreds(){
		//One million two thousand one hundred twenty two
		//For each 100s> break down and repeat first loop *times index of num
		Converter con=new Converter();ArrayList<NumberObj> allNums=new ArrayList<>();NumberSet set=new NumberSet();
		String single="One Thousand Three Hundred"; int spaces = (int) single.chars().filter(n -> n == (int)' ').count();
		System.out.println(con.getHundreds(single));
	}

	@Test
	void hundredsLoop(){
		Converter con=new Converter();
		String num="Two Thousand One"; String [] split= num.split(" ");
		System.out.println(con.hundredsLoop(num));
	}

	@Test
	void getNumberFromFile(){
		UseFile useFile=new UseFile();
		useFile.readNumbers("src/main/resources/numbersFile.txt").forEach(x->{
			System.out.println(x);
		});
	}

	@Test
	void divideArray(){
		ArrayList<NumberObj> testArr= new ArrayList<>(Arrays.asList(new NumberObj(3, "Three"), new NumberObj(6, "Six"),
				new NumberObj(7, "Seven"), new NumberObj(8, "Eight"), new NumberObj(19, "Nineteen"),
				new NumberObj(20, "Twenty"), new NumberObj(88, "Eighty Eight")));
		UseFile useFile=new UseFile();
		useFile.display(useFile.format(3,testArr));
	}

	@Test
	public void centerString () {
		int width = 20; String s = "center";
		int padSize = width - s.length(), padStart = s.length() + padSize / 2;
		s = String.format("%" + padStart + "s", s);
		s = String.format("%-" + width  + "s", s);
		System.out.println("|"+s+"|");
	}

	@AfterEach
	void tearDown(){
		System.out.println("Tests Complete");
	}

}
