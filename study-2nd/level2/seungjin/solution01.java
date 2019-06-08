class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        
        int x=0;
        int y=0;
        
        //x, y
        int add = (brown+4)/2;
        int mul = brown + red;
        
        for(int i=0; i<=add; i++){
            x = i;
            y =  (add-i);
            
            if(x*y == mul){
                break;
            }
        }
        
        if(x<y){
            int temp = x;
            x = y;
            y = temp;
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}
