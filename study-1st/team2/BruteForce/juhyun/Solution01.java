import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Solution01 {

    public int[] solution(int[] answers) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        HashMap<Integer,Integer> score = new HashMap<>();

        score.put(1,0);
        score.put(2,0);
        score.put(3,0);

        for(int i = 0; i<answers.length; i++){
            if(answers[i] == a[i%5]) score.replace(1,score.get(1)+1);
            if(answers[i] == b[i%8]) score.replace(2,score.get(2)+1);
            if(answers[i] == c[i%10]) score.replace(3,score.get(3)+1);
        }

        //최댓값 찾기
        Collection<Integer> values = score.values();
        int max = Collections.max(values);

        //리스트에 최댓값 넣기
        ArrayList<Integer> scoreList = new ArrayList<>();

        for(int i = 1; i<=score.size(); i++){
            if(max == score.get(i)) {
                scoreList.add(i);
            }
        }

        //정답 배열 만들기
        int[] answer = new int[scoreList.size()];

        for(int i = 0; i<scoreList.size(); i++){
            answer[i] = scoreList.get(i);
        }

        return answer;
    }
}
