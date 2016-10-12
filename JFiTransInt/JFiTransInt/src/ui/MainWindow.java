package ui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainWindow extends BaseWindow{
	
	protected JButton button;
	protected JPanel panel;
	
	//Constructor
	public MainWindow(){
		super("Main Window", 300, 300);
	}
	
	
	@Override
	protected void build() {
		
		button = new JButton("I'm a button");
		button.setBounds(0, 0, 100, 25);
		
		
		frame.add(panel);
	}
	
}
