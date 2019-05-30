function solution(nums) {
    // 폰켓몬 배열의 중복 제거
    var uniq = nums.reduce(function(a, b) {
        if (a.indexOf(b) < 0) {
            a.push(b);  
        } 
        return a;
    }, []);
    
    const ponketmonTypeNumber = uniq.length; // 폰켓몬의 종류
    const ponketmonPickNumber = nums.length/2; // 폰켓몬을 선택할 수 있는 갯수
    
    if (ponketmonTypeNumber >= ponketmonPickNumber) {
        return ponketmonPickNumber;
    }
    else {
        return ponketmonTypeNumber;
    }
}
