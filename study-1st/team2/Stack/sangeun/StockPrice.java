public class StockPrice {
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        boolean[] flag = new boolean[prices.length];
        for (int i = 0 ; i < prices.length ; i++) {
        		int temp = prices[i];
        		for (int j = 0 ; j < i ; j++) {
        			if (!flag[j] && temp >= prices[j]) {
        				answer[j]++;
        			} else {
        				if (!flag[j]) {
        					answer[j]++;
        				}
        				flag[j] = true;
        			}
        		}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] result = solution(prices);
		for (int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i]);
		}
		
	}
}

