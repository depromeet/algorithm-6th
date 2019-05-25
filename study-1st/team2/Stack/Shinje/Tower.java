class Tower {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Integer> stack = new Stack<Integer>();
		int len = heights.length;

		for (int i = 0; i < len; i++) {
			stack.push(heights[i]);
		}

		for (int i = len - 1; i >= 0; i--) {
			if (heights[i] > stack.peek()) {
				answer[i] = i + 1;
				stack.pop();
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}
}
