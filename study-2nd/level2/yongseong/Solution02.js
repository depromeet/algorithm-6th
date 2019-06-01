function solution(n) {
    const naturalNumber = n;
    const originalBinaryNumber = naturalNumber.toString(2);
    const originalNumberOfOne = originalBinaryNumber.match(/1/g).length;
    
    // n++ 인 반복문
    while (n < 1000000) {
        // 증가된 n을 2진수로 변환
        n++;
        var binaryNumber = n.toString(2);
        var numberOfOne = binaryNumber.match(/1/g).length;
        
        // 원래 n과 증가된 n의 2진수의 1의 갯수를 비교해서 맞으면 n을 return
        if (originalNumberOfOne == numberOfOne) {
            return n;
        }
    }
}
