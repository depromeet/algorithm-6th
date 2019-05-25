public class NumberBaseball {
	public static int solution(int[][] baseball) {
		int answer = 0;
		
		for (int i = 100 ; i <= 999 ; i++) {
			String temp = String.valueOf(i);
			if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || temp.charAt(0) == temp.charAt(2)) {
				continue;
			}
			if (temp.charAt(0) == '0' || temp.charAt(1) == '0' || temp.charAt(2) == '0') {
				continue;
			}
			boolean flag = true;
			for (int j = 0 ; j < baseball.length ; j++) {
				String A = String.valueOf(baseball[j][0]);
				int strike = 0;
				int ball = 0;
				for (int k = 0 ; k < 3 ; k++) {
					for (int l = 0 ; l < 3 ; l++) {
						if (k == l && temp.charAt(k) == A.charAt(l)) {
							strike++;
						}
						if (k != l && temp.charAt(k) == A.charAt(l)) {
							ball++;
						}
					}
				}
				if (strike != baseball[j][1] || ball != baseball[j][2]) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				answer++;
			}
		}
        return answer;
    }
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(solution(baseball));
	}
}

