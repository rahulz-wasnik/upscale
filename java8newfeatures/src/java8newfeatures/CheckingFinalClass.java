package java8newfeatures;

import java.util.HashMap;

final class FinalClass {

	private final String name;
	
	static final int ELEMENT = 1;
	
	private int i;
	
	public FinalClass() {
		this.name = "";
	}
	
	public FinalClass(String name) {
		this.name = name;
	}
}


public class CheckingFinalClass {
	
	public static void main(String[] args) {
		FinalClass ch = new FinalClass();
		String s = new String();
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> map2 = new HashMap<>(map);
		
	}
}