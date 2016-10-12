package main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import jars.Test;
import jars.annotations.JarsField;

public class JFiTransInt {
	
	public static void main(String[] args){
		
		Class<Test> cl1 = Test.class;
		
		//printArray(cl1.getFields()[0].getAnnotations());
		
		List<Field> fields = getFieldsWithAnnotation(cl1);
		
		for (Field field : fields) {
			JarsField jars = field.getAnnotation(JarsField.class);
			System.out.println(jars.fieldName());
		}
		
	}
	
	
	public static <T> void printArray(T[] array){
		Arrays.stream(array).forEach(x -> System.out.println(x));
	}
	
	
	public static <T> List<Field> getFieldsWithAnnotation(Class<T> c1) {
		List<Field> list = new ArrayList<Field>();
		
		getStream(c1.getFields()).filter(f -> getStream(f.getAnnotations()).anyMatch(a -> a.annotationType().equals(JarsField.class))).forEach(x -> list.add((Field) x));
		
		return list;
	}
	
	
	public static <T> Stream<T> getStream(T[] array) {
		return Arrays.stream(array);
	}
}

