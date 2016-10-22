package jars;

import java.lang.reflect.Field;

import jars.annotations.JarsField;

public class Test {
	
	@JarsField(fieldName = "String")
	public String aString;
	
	@JarsField(fieldName = "Another String")
	public String secondString;
	
	@Override
	public String toString() {
		String fields = "";
		for (Field field : this.getClass().getFields()) {
			try {
				fields += field.getName() + ": " + field.get(this).toString() + "\n";
			} catch (Exception ex){
				fields += ex.getMessage() + "\n";
			}
			
		}
		return fields;
	}
}
