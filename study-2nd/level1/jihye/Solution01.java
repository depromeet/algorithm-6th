class Solution {
  public int[] solution(int n, int m) {
      int[] answer;
      int big, small, remainder, quotient;
      int gcm, lcm;

      if(n >= m){
         big = n;
          small = m;
      }else{
          big = m;
          small = n;
      }

      while(true){
          quotient = big/small;
          remainder = big - (quotient * small);
          if(remainder == 0){
              gcm = small;
              lcm = (n*m) / gcm;
              break;
          }
          big = small;
          small = remainder;
      }
    answer = new int[] {gcm, lcm}; 
    return answer;
  }
}
