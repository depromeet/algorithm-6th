import java.util.ArrayList;

class Solution {
    public int solution(String arrangement) {
        ArrayList<Integer> laserArray = new ArrayList<>();
        int answer = 0, start = 0, index = -2;
        int stick = 0; // 막대기의 개수

        // 레이저의 위치를 구한다
        while (true) {
            int temp = arrangement.indexOf("()", start++);
            if (temp == -1) break;

            if (index != temp) {
                index = temp;
                laserArray.add(index);
            }
        }

        for (int i = 0, j = 0; i < arrangement.length(); i++) {
            if ((arrangement.charAt(i) == '(') && i != laserArray.get(j)) {
                stick++; // '(' 기호 등장시 절단할 막대기 추가
            } else if (arrangement.charAt(i) == ')') {
                stick--; // ')' 기호 등장시 절단할 막대기 제거
                answer++;
            } else if (i == laserArray.get(j)) { // 레이저 등장시 절단
                answer += stick;
                i++;
                j++;
            }
        }

        return answer;
    }
}