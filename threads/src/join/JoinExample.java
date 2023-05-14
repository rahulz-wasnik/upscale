package join;

class ThreadJoining extends Thread {

	ThreadJoining() {
	}

	ThreadJoining(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(500);
				System.out.println("Current Thread in ThreadJoining: " + Thread.currentThread().getName());
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}
		}
	}
}

public class JoinExample {
	public static void main(String[] args) {

		// creating two threads
		ThreadJoining t1 = new ThreadJoining("T1");
		ThreadJoining t2 = new ThreadJoining("T2");
		ThreadJoining t3 = new ThreadJoining("T3");

		// thread t1 starts
		t1.start();

		// starts second thread after when
		// first thread t1 has died.
		try {
			System.out.println("Current Thread JoinExample: " + Thread.currentThread().getName());
			t1.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has " + "been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 has died.
		try {
			System.out.println("Current Thread JoinExample after t2 start: " + Thread.currentThread().getName());
			t2.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		t3.start();

		try {
			System.out.println("Current Thread JoinExample after t2 start: " + Thread.currentThread().getName());
			t3.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been" + " caught" + ex);
		}

		System.out.println("Current Thread End: " + Thread.currentThread().getName());
	}
}