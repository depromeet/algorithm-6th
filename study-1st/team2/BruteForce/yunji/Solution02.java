public class Solution02 {
    public boolean checkNumber(String numbers, int num) {
        int[] countList = new int[10];
        int[] checkList = new int[10];
        for (int i = 0; i < numbers.length(); i++)
            countList[numbers.charAt(i) - '0']++;

        while (num != 0) {
            if (countList[num % 10] == 0 ||
                    checkList[num % 10] >= countList[num % 10])
                return false;

            checkList[num % 10]++;
            num /= 10;
        }

        return true;
    }

    public int solution(String numbers) {
        int answer = 0;

        for (int i = 2; i < Math.pow(10, numbers.length()) - 1; i++) {
            if (checkNumber(numbers, i)) {
                if (isPrime(i)) {
                    System.out.println(i);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int n) {
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
