class Solution01{
    public int solution(String arrangement) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i =0; i<arrangement.length(); i++){
            char mark = arrangement.charAt(i);
            if(mark == '('){
                stack.push(mark);
            }
            else if(mark == ')'){
                stack.pop();

                if(arrangement.charAt(i-1) == '('){
                    answer += stack.size();
                }
                else
                    answer++;
            }
        }
        return answer;
    }
}
