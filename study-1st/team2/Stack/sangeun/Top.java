public class Top {
	public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for (int i = heights.length - 1 ; i > 0 ; i--) {
        		for (int j = i - 1 ; j >= 0 ; j--) {
        			if (heights[i] < heights[j]) {
        					answer[i] = j + 1;
        				break;
        			}
        		}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] heights = {3,9,9,3,5,7,2};
		int[] result = solution(heights);
		for (int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
