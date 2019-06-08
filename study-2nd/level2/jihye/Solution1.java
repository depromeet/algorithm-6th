class Solution {
    public String solution(String s) {
        // answer: Jaden Case로 바꾼 문자열
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            // 문자열의 맨 첫번째 문자이거나 바로 앞이 공백인 문자인 경우
            if (i == 0 || s.charAt(i-1) == ' ') {
                answer += Character.toString(s.charAt(i)).toUpperCase();
            } else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
        }
        return answer;
    }
}
