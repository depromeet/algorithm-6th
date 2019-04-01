import java.util.*;

class B3 {
	int progress;
	int speed;
	public B3(int progress, int speed) {
		// TODO Auto-generated constructor stub
		this.progress = progress;
		this.speed = speed;
	}
}
public class FunctionDevelop {
	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<B3> queue = new LinkedList<>();
        ArrayList<Integer> Arr = new ArrayList<>();
        // 큐에 모든 작업 추가 
		for (int i = 0 ; i < progresses.length ; i++) {
			queue.add(new B3(progresses[i], speeds[i]));
		}
		
		
		while (!queue.isEmpty()) {
			// 제일 처음 작업 종료시점까지의 day 계산 
			B3 temp = queue.peek();
			int day = (int)Math.floor(1.0 * (100 - temp.progress) / temp.speed);
			
			// 모든 작업에 day만큼 추가 
			Iterator<B3> iter = queue.iterator();
			while (iter.hasNext()) {
				B3 temp2 = iter.next();
				temp2.progress += temp2.speed * day;
			}
			
			// 100이 넘는 작업들 queue에서 제거, count++ 
			int count = 0;
			while (!queue.isEmpty()) {
				B3 temp3 = queue.peek();
				if (temp3.progress >= 100) {
					count++;
					queue.poll();
				} else {
					break;
				}
			}
			
			if (count != 0) {
				Arr.add(count);
			}
		}
		// 출력 부분 
        int[] answer = new int[Arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Arr.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] speeds = {1, 30, 5 , 10, 60, 7};
		int[] progresses = {93, 30, 55, 60, 40, 65};
		int[] result = solution(progresses, speeds);
		for (int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

