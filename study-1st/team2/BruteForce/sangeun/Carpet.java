public class Carpet {
	public static int[] solution(int brown, int red) {
        int T = (int)Math.ceil(Math.sqrt(brown + red));

        for (int i = T;  ; i++) {
        		for (int j = T; j >= 0 ; j--) {
        			if (i * j == brown + red && 2 * (i + j) - 4 == brown) {
        				int[] answer = {i, j};
        		        return answer;
        			}
        		}
        }
        
        
        
    }
	public static void main(String[] args) {
		int brown = 10;
		int red = 2;
		int[] result = solution(brown, red);
		
		for (int i = 0 ; i < result.length ; i++) {
			System.out.print(result[i]);
		}
	}
}

