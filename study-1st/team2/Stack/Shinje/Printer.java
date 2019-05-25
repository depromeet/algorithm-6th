import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Printer {

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println("answer = " + solution(priorities, location));

	}


	public static int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<Integer> q = new LinkedList<Integer>();

		for(int item : priorities) {
			q.add(item);
		}

		while(q.size() != 0) {

		}

		return answer;




//		배열의 값과 스택의 값을 비교해서 문제를 해결하려고 했으나 실패.
//		int answer = 0;
//		Queue<Integer> q = new LinkedList<Integer>();
//		Queue<Integer> ordered_q = new PriorityQueue<Integer>();
//
//		for (int items : priorities) {
//			q.add(items);
//			ordered_q.offer(items);
//		}
//
//		System.out.println("q= " + q.size());
//		System.out.println("ordered_q= " + ordered_q.size());
//
//		return answer;
	}



//	Queue의 Max값을 구하는 메소드를 만들기 위해 시도
//	public int getMaxQueueElement(Queue<Integer> queue) {
//		PriorityQueue<E> pQueue = new PriorityQueue<>((E e1, E e2)->e1.compareTo(e2));
//	    pQueue.addAll(queue);
//	    System.out.println(pQueue.peek());
//	    return max;
//	}
}
