import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
       int[] answer = null;
		int[] num_1 = { 1, 2, 3, 4, 5 };
		int[] num_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] num_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int count_1 = 0;
		int count_2 = 0;
		int count_3 = 0;
		int max_count = 0;

		for (int i = 0; i < answers.length; i++) {

			if (num_1[i%5] == answers[i]) count_1++;
			if (num_2[i%8] == answers[i]) count_2++;
			if (num_3[i%10] == answers[i]) count_3++;

		}

		max_count = Math.max(count_1, Math.max(count_2, count_3));

		List<Integer> list = new ArrayList<>();
		if(max_count == count_1) list.add(1);
		if(max_count == count_2) list.add(2);
		if(max_count == count_3) list.add(3);

		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = (int) list.get(i);
		}


		return answer;
    }
}
