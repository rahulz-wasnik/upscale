package java8newfeatures;

class Car {
	public int getBrake() {
		return brake;
	}

	public int getClutch() {
		return clutch;
	}

	private int brake;
	private int clutch;
	
	public Car(int brake, int clutch) {
		this.brake = brake;
		this.clutch = clutch;
		System.out.println("Constructor");
	}
	
	{
		System.out.println("Initialization block");
	}
	
	static {
		System.out.println("Static Initialization block");
	}
}

public class BlockExecutionOrderInJava {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Car car = new Car(1, 2);
//		Car car2 = new Car(1, 2);
//		Car car3 = new Car(1, 2);
		String r = "abc";
		String[] a = r.split("");
	}

}
