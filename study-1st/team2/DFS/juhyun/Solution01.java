public class Solution01 {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        DFS(target, numbers, 0);
        return answer;
    }

    public void DFS(int target, int[] numbers, int depth) {
        if(depth == numbers.length) {
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            if(sum == target) {
                answer++;
            }
            return;
        }
        else {
            numbers[depth] *= 1;
            DFS(target, numbers, depth + 1);

            numbers[depth] *= -1;
            DFS(target, numbers, depth + 1);
        }
    }
}
