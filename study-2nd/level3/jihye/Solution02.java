import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[computers.length];
        
        // answer: 네트워크의 개수
        int answer = 0;
        for(int i = 0, i < n; i++){
            IsNetwork(i);
        }
        
        return answer;
    }
    
    // bfs() 
    public void IsNetwork(){
        Queue<Integer> queue = new Queue<Integer>();
        
        }
    }

}
