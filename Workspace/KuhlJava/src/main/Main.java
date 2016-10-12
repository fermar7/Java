package main;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args){
		
		List<String> list = new ArrayList<String>();
		
		list.add("Hans");
		list.add("Ulf");
		list.add("Gustav");
		
		list.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
	}
}

