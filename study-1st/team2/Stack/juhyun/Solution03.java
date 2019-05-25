import java.util.Stack;

class Solution03{
    public static void main(String[] args) {

//        int[] heights = {6,9,5,7,4};
        int[] heights = {3,9,9,3,5,7,2};

        for(int i = 0; i < heights.length; i++){
            int[] result = new Solution03().solution(heights);
            System.out.println("result = " + result[i]);
        }
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int size = heights.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< size ; i++)
            stack.push(heights[i]);

        //answer[]에 들어가는 index
        int index = size-1;

        while(!stack.empty()) {
            int top = stack.pop();

            for (int i = stack.size() - 1; i >= 0; i--) {
                if (top < heights[i]) {
                    answer[index] = i+1;
                    break;
                }
            }
            index--;
        }
        return answer;
    }
}
