package rithm3.algo;

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
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        // 큐에 작업 일수 추가 
        // 작업이 몇 일 걸리는지 계산 
		for (int i = 0 ; i < progresses.length ; i++) {
			queue.add((int)Math.floor(1.0 * (100 - progresses[i]) / speeds[i]));
		}
		

		int count = 1;
		int temp = queue.poll();
		while (!queue.isEmpty()) {
			if (temp >= queue.peek()) {
				// queue의 처음과 같이 배포되는 작업(앞 작업보다 일찍 끝난 작업) 
				count++;
				queue.poll();
			} else {
				// 앞 작업과 같이 배포되지 않는 오래 걸리는 작업
				result.add(count);
				count = 1; 
				temp = queue.poll();	
			}
		}
		
//		while (!queue.isEmpty()) {
//			int count = 1;
//			
//			int temp = queue.poll();
//			while (!queue.isEmpty() && temp > queue.peek()) {
//				queue.poll();
//				count++;
//			}
//			Arr.add(count);
//		}
		// 마지막 결과 result에 추가 
		result.add(count);
		
		// 출력 부분 
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
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

