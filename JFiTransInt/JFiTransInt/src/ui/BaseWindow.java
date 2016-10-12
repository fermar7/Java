package ui;

import javax.swing.*;

public class BaseWindow {

	protected JFrame frame;
	protected boolean isOpen = false;
	
	protected BaseWindow(String title, int width, int height) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLayout(null);
		this.build();
	}
	
	protected void build() {
		frame.setSize(200, 200);
		
	}
	
	public void open(){
		if(!isOpen){
			frame.setVisible(true);
			this.isOpen = true;
		}
	}
	
	public void close(){
		if(isOpen){
			frame.setVisible(false);
			this.isOpen = true;
		}
	}
}
