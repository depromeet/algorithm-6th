import java.util.Arrays;

class Solution {
  public String solution(String[] seoul) {
      String answer = "";

      int x = Arrays.asList(seoul).indexOf("Kim");
      answer = "김서방은 " + x + "에 있다";


      return answer;
  }
}
