function solution(n) {
    var result = [];

    for(var i = 1; i <= n; i++){
        if(i%2 == 1){
            result += "수";
        }else{
            result += "박";
        }
    }
    return result;
}