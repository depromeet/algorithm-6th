function solution(n) {
    var answer = 0;
    
    if(n>2){
        answer = (n-2) + (n-1);
        if(answer == 3){
            answer = answer - 1;
        }else if(answer > 3){
            answer = answer - 2;
        }
    }else if(n<=2){
        answer = 1;
    }else{
        return n;
    }
       
    answer = Math.round(answer%1234567);   
    return answer;
}