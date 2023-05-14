package java8newfeatures;

import java.util.Arrays;

/**
 * @author Rahul
 *
 */
public class FP01Functional {

	public Integer[] list;
	int position = 1;

	public FP01Functional(Integer[] list) {
		this.list = list;
	}

	public void remove() {
		System.out.println("First"+ list[position - 1]);
		if (list[position - 1] != null) {
			for (int i = position - 1; i < (list.length - 1); i++) {
				System.out.println("list[" + i + "] and list[" + (i+1) + "] " + list[i] + " " + list[i+1]);
				list[i] = list[i + 1];
 				System.out.println("list["+ i + "] " + list[i]);
 				printlist();
			}
			list[list.length - 1] = null;
			printlist();
		}
	}
	
	public void printlist() {
		System.out.println("List is - " +Arrays.toString(list));
	}

	public static void main(String args[]) {
		Integer[] arrayOfIntegers = new Integer[3];
		arrayOfIntegers[0]  = 1;
		arrayOfIntegers[1]  = 2;
		arrayOfIntegers[2]  = 3;
//		FP01Functional fp01Functional = new FP01Functional(arrayOfIntegers);
//		fp01Functional.remove();
		
		int str = 7044;
		String s = String.format("%d", str);
		
		System.out.println(s);
		System.out.println(s.length());
	}

}
