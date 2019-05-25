import java.util.*;

public class Solution02 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();

        if (priorities.length == 1)
            return 1;

        for (int priority : priorities)
            linkedList.add(priority);

        while (true) {
            Integer value = linkedList.pollFirst();
            if (linkedList.isEmpty())
                return priorities.length;

            int max = Collections.max(linkedList);

            if (value < max) {
                linkedList.addLast(value);

                if (location == 0)
                    location = linkedList.size();
            } else {
                answer++; // 값이 하나 빠져나갈 때 1씩 증가

                if (location == 0)
                    break;
            }

            location--;
        }

        return answer;
    }
}
