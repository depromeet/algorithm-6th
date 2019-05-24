function solution(s){
    
    // Regex count
    var pCount = (s.match(/[pP]/g) || []).length;
    var yCount = (s.match(/[yY]/g) || []).length;
    
    return pCount == yCount;
}

