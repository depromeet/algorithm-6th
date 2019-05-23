function solution(x, n) {
    var array = [];
    const plusNumber = x;
    // n만큼 반복합니다.
    for ( var i = 0; i < n; i++ ) {
        // x를 배열에 삽입합니다.
        array.push(x);
        // x를 증가시킵니다.
        x += plusNumber;
    }
    // 배열을 리턴합니다.
    return array;
}
