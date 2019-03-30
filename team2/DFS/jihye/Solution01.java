class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        depthFirstSearch(numbers, target, 1, numbers[0]);
        depthFirstSearch(numbers, target, 1, (-1) * numbers[0]);
        return answer;
    }

    public void depthFirstSearch(int[] numbers, int target, int depth, int sum){
        if(depth >= numbers.length){
            if(sum==target)
                answer++;
            return;
        }
        depthFirstSearch(numbers,target, depth+1 , sum + numbers[depth]);
        depthFirstSearch(numbers,target, depth+1 , sum - numbers[depth]);
    }
}