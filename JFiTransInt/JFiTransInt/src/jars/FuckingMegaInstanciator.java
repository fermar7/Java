package jars;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import jars.annotations.JarsField;

public class FuckingMegaInstanciator<E> {
	
    public E fuckingMagic(Class<E> clazz) {
    	
    	try {
    		E fuckingInstance = clazz.newInstance();
    		
    		List<String[]> list = getFuckingFieldsWithFuckingAttribute(clazz);
    		
    		for (String[] field : list) {
    			Field fuckingField = fuckingInstance.getClass().getField(field[0]);
        		
        		fuckingField.set(fuckingInstance, fuckingField.getType().cast("Jo") );
    		}
    		return fuckingInstance;
    		
    	} catch (Exception fuckingException) {
    		return null;
    	}
        
    }
    
    private List<String[]> getFuckingFieldsWithFuckingAttribute(Class<E> cl){
    	
    	List<Field> list = new ArrayList<Field>();
    	List<String[]> result = new ArrayList<String[]>();
		
		getStream(cl.getFields()).filter(f -> getStream(f.getAnnotations()).anyMatch(a -> a.annotationType().equals(JarsField.class))).forEach(x -> list.add((Field) x));
		
		for (Field field : list) {
			JarsField jars = field.getAnnotation(JarsField.class);
			result.add(new String[] {field.getName(), jars.fieldName()});
		}
		
		return result;
    	
    }
    
    public static <T> Stream<T> getStream(T[] array) {
		return Arrays.stream(array);
	}
	
}