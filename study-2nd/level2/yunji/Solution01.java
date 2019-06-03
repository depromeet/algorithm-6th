public class Solution01 {
    static boolean solution(String s) {
        int leftSide = 0, rightSide = 0;
        char[] input = s.toCharArray();
        for (char c : input) {
            if (c == '(') {
                leftSide++;
            } else {
                rightSide++;
            }

            if (rightSide > leftSide) return false;
        }

        return (leftSide == rightSide);
    }
}