function solution(s){
    if(s.match(/p/gi).length == s.match(/y/gi).length){
        return true;
    }else if(s.match(/p/gi).length && s.match(/y/gi).length == 0){
        return true;
    }else{
        return false;
    }
}