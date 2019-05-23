class Solution {
  public long solution(int a, int b) {
      long answer = 0;

      if(a > b){
          int temp = a;
          a = b;
          b = temp;
      }


      answer = (b*(b+1)/2) - (a*(a-1)/2);

      return answer;
  }
}
