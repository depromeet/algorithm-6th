// 완전탐색 - 숫자야구
public class Solution03 {
    public static void main(String[] args) {
        int[][] test = new int[][]{
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}
        };

        int an = new Solution03().solution(test);
        System.out.println(an);
    }

    public int[] splitNumber(int num) {
        return new int[]{num / 100, num % 100 / 10, num % 10};
    }

    public int solution(int[][] baseball) {
        int answer = 0, count = 0;
        int s = 0, b = 0;

        for (int i = 123; i <= 999; i++) {
            for (int[] ints : baseball) {
                int[] numArray = splitNumber(ints[0]); // 비교할 숫자
                int[] candidateArray = splitNumber(i); // 후보 숫자

                // 스트라이크 검사
                for (int j = 0; j < 3; j++) {
                    if (numArray[j] == candidateArray[j])
                        s++;
                }

                // 볼 검사
                for (int j = 0; j < 3; j++) {
                    if (numArray[j] != candidateArray[j]) {
                        if (j != 0 && numArray[j] == candidateArray[0])
                            b++;
                        else if (j != 1 && numArray[j] == candidateArray[1])
                            b++;
                        else if (j != 2 && numArray[j] == candidateArray[2])
                            b++;
                    }
                }

                if (s == ints[1] && b == ints[2])
                    count++;

                s = 0;
                b = 0;
            }

            if (baseball.length == count) {
                if (!String.valueOf(i).contains("0"))
                    answer++;
            }

            count = 0;
        }
        return answer;
    }
}
