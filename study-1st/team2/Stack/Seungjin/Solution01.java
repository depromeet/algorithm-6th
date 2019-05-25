import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
		int pieces=0;
		int i =0;
		
		Stack<Character> stack = new Stack<Character>();
		char handing = '0';
		
		while(arrangement.length() != i) {
			if(arrangement.charAt(i) == ')') {
				if(handing == '(') {
					pieces += stack.size();
					handing='0';
				}
				
				else if (handing == '0') {
					pieces +=1;
					stack.pop();
				}
				
				else
					handing = arrangement.charAt(i);
				
			}
			
			
			else if(arrangement.charAt(i) == '(') {
				if(handing == '(') {
					stack.push((Character)handing);
				}
					
				
			handing = arrangement.charAt(i);
				

			}
			
			i++;
			
			
		}
        
   return pieces;     
}
    
}
