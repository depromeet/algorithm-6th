public class Solution02 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] count = new int[9];
        int num = priorities[location];

        for (int priority : priorities)
            count[priority - 1]++;

        for (int i = count.length - 1; i > num - 1; i--) {
            answer += count[i];
        }

        if (count[num - 1] > 1) {
            for (int i = priorities.length - 1; i > location; i--) {
                if (priorities[i] == num)
                    answer++;
            }
        } else
            answer = 1;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution02().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
        System.out.println("-----------------------");
        System.out.println(new Solution02().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println("-----------------------");
    }
}
