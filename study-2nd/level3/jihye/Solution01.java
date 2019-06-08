import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int lastIndex = works.length-1;
        
        while(n > 0){
            Arrays.sort(works);
            
            // 배열 works의 모든 원소가 0일때
            if(works[lastIndex] == 0){
                break;
            }
            
            works[lastIndex]--; 
            n--;
        }
        
        long answer = 0;
        for( int work : works ){
            answer += work * work;
        }
        return answer;
    }
}
