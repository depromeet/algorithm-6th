import java.util.ArrayList;

// 완전탐색 - 모의고사
public class Solution01 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] count = new int[3];
        int[][] answerSet = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answerSet[0][i % 5])
                count[0]++;

            if (answers[i] == answerSet[1][i % 8])
                count[1]++;

            if (answers[i] == answerSet[2][i % 10])
                count[2]++;
        }

        int max = (count[0] > count[1]) ? count[0] : count[1];
        max = (max > count[2]) ? max : count[2];

        for (int i = 0; i < 3; i++) {
            if (max == count[i])
                result.add(i + 1);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}