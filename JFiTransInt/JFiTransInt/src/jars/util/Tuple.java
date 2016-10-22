package jars.util;

public class Tuple<T1, T2> {
	
	private T1 Value1;
	
	private T2 Value2;

	public Tuple(T1 value1, T2 value2) {
		Value1 = value1;
		Value2 = value2;
	}

	public T1 getValue1() {
		return Value1;
	}

	public T2 getValue2() {
		return Value2;
	}
	
}
