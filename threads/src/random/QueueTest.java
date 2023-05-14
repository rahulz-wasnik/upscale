package random;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main (String args[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
		queue.poll();
		queue.poll();
		System.out.println(queue);
	}
}
