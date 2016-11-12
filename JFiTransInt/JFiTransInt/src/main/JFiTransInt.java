package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;

import jars.JarsPanel;
import jars.Test;

public class JFiTransInt {
	
	public static void main(String[] args){
		
		
		
		
		Class<Test> cl1 = Test.class;
		
		//printArray(cl1.getFields()[0].getAnnotations());
		
		
		JarsPanel<Test> test = new JarsPanel<Test>(cl1);
		
		JFrame frame = new JFrame("Cool");
		
		frame.setLayout(null);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);
		
		frame.add(test);
		
		JButton button = new JButton();
		button.setBounds(200, 200, 100, 50);
		
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Test t = test.getInstance();
				
				System.out.println(t);
				
			}
		};
		
		button.addActionListener(action);
		
		frame.add(button);
		
	}
	
	public static <T> void printArray(T[] array){
		Arrays.stream(array).forEach(x -> System.out.println(x));
	}
	
}

