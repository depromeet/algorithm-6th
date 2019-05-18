import java.util.Stack;

class IronBar {
    public int solution(String arrangement) {
      int answer = 0;
  		arrangement = arrangement.replace("()", "C");
  		String[] arr = arrangement.split("");
  		Stack<String> stack = new Stack<String>();

  		for (int i = 0; i < arr.length; i++) {
  			if (arr[i].equals("(")) {
  				stack.push("(");
  			} else if (arr[i].equals(")")) {
  				stack.pop();
  				answer += 1;
  			} else {
  				answer += stack.size();
  			}
  		}

  		return answer;
    }
}
