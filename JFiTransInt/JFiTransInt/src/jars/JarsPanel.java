package jars;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.*;

import jars.annotations.JarsField;
import jars.util.Tuple;

public class JarsPanel<E> extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Class<E> theClass;
	
	public JarsPanel(Class<E> clazz) {
		super();
		this.theClass = clazz;
		this.setLayout(null);
		generateInputFields();
	}

	public E getInstance() {
    	
    	try {
    		E instance = this.theClass.newInstance();
    		
    		List<Tuple<String, String>> list = getFields();
    		
    		for (Tuple<String, String> tuple : list) {
    			Field fuckingField = instace.getClass().getField(tuple.getValue1());
        		Optional<Component> optinalText = Arrays.stream(this.getComponents()).filter(txt -> txt.getName() == tuple.getValue1()).findFirst();
    			if(optinalText.isPresent()) {
    				JTextField text = (JTextField) optinalText.get();
    				fuckingField.set(instace,  text.getText());
    			}

    		}
    		return instace;
    		
    	} catch (Exception ex) {
    		return null;
    	}
        
    }
	
	private void generateInputFields() {
		List<Tuple<String, String>> list = getFields();
		
		for (int i = 0; i < list.size(); i++) {
			JTextField text = new JTextField();
			JLabel label = new JLabel(list.get(i).getValue2());
			
			label.setBounds(0, i * 30, 100, 25);
			
			text.setName(list.get(i).getValue1());
			text.setBounds(100, i * 30, 100, 25);
			
			this.add(label);
			this.add(text);
		}
		this.setBackground(Color.LIGHT_GRAY);
		this.setBounds(0, 0, 200, list.size() * 30);
	}
    
	
    private List<Tuple<String, String>> getFields() {

    	List<Tuple<String, String>> result = new ArrayList<Tuple<String, String>>();
		
    	Arrays.stream(this.theClass.getFields()).filter(f -> 
    		Arrays.stream(f.getAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(JarsField.class)))
						.forEach(field -> {
							String fieldName = field.getAnnotation(JarsField.class).fieldName();
							result.add(new Tuple<String, String>(field.getName(), fieldName));
						});
							
		return result;
    	
    }
    
}
