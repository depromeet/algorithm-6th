import java.util.*;

public class Test {
	public static int[] solution(int[] answers) {
        
		int[] num1 = {1, 2, 3, 4, 5};
		int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int player1 = 0;
		int player2 = 0;
		int player3 = 0;
		
		for (int i = 0 ; i < answers.length ; i++) {
			if (answers[i] == num1[i % 5]) {
				player1++;
			}
			if (answers[i] == num2[i % 8]) {
				player2++;
			}
			if (answers[i] == num3[i % 10]) {
				player3++;
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int max = Math.max(player1, Math.max(player2, player3));
		
		if (player1 == max) {
			result.add(1);
		}
		if (player2 == max) {
			result.add(2);
		}
		if (player3 == max) {
			result.add(3);
		}
		Collections.sort(result);
        	int[] answer = new int[result.size()];
        	for (int i = 0; i < answer.length; i++) {
        		answer[i] = result.get(i);
        	}
        return answer;
    }
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		int[] result = solution(answers);
		
		for (int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
	}
}

