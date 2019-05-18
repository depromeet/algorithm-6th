public class PrimeNumber {
	public int solution(String numbers) {
		int answer = 0;
		return answer;
	}

	public int[] getNumberArr(String numbers) {
		// 순열을 이용해서 가능한 모든 경우의 수를 만듦
		// 순열 부분이 어려워서 코드를 보며 이해하는 중입니다
		int[] result = null;

		return result;
	}

	public int getPrimeNumberCount(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if ((j != 1) & (i % j == 0)) {
					break;
				} else if (j + 1 > Math.sqrt(i)) {
					count++;
				}
			}
		}

		return count;
	}

}
