package main;

import java.util.Arrays;

import jars.FuckingMegaInstanciator;
import jars.Test;

public class JFiTransInt {
	
	public static void main(String[] args){
		
		Class<Test> cl1 = Test.class;
		
		//printArray(cl1.getFields()[0].getAnnotations());
		
		FuckingMegaInstanciator<Test> test = new FuckingMegaInstanciator<Test>();
		
		Test t = test.fuckingMagic(cl1);
		
		System.out.println(t.aNumber);
	}
	
	public static <T> void printArray(T[] array){
		Arrays.stream(array).forEach(x -> System.out.println(x));
	}
	
}

