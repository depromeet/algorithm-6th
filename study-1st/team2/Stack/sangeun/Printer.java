import java.util.*;

class B1 {
	int priority;
	boolean check = false;
	public B1(int priority, boolean check) {
		// TODO Auto-generated constructor stub
		this.priority = priority;
		this.check = check;
	}
}
public class Printer {
	
	// target의 priority 가 queue에서 제일 큰 수인지 체크
	// true : 제일 큰 수
	// false : X
	public static boolean checkFunc(Queue<B1> queue, B1 target) {
		boolean result = true;
		Iterator<B1> iter = queue.iterator();
		while (iter.hasNext()) {
			if (target.priority < iter.next().priority) {
				result = false;
				break;
			}
		}
		return result;
	}
	public static int solution(int[] priorities, int location) {
		Queue<B1> queue = new LinkedList<>();
		
		// 모든 priority 값 queue에 add
		for (int i = 0 ; i < priorities.length ; i++) {
			// location 값은 true, 나머지는 false
			if (location == i) {
    				queue.add(new B1(priorities[i], true));
	    		} else {
	    			queue.add(new B1(priorities[i], false));
	    		}
		}
		
		int count = 1;
		while (true) {
			if (!checkFunc(queue, queue.peek())) {
				// queue에 더 큰 수가 있을 경우 => 큐의 제일 뒤에 삽
				B1 temp = queue.poll();
				queue.add(temp);
			} else {
				B1 temp = queue.poll();
				if (temp.check) {
					// location! break
					break;
				} else {
					// queue에서 삭제하고 count 증
					count++;
				}
			}
		}
		
		return count;
    }
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 3;
		System.out.println(solution(priorities, location));
	}
}

