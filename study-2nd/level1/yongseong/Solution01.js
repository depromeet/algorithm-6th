function solution(phoneNumber) {
    // 전화번호 뒷 4자리를 추출합니다.
    const backFourNumber = phone_number.slice(phone_number.length - 4);
    // 전화번호 길이만큼 *를 생성합니다.
    var star = '';
    for ( var i = 0; i < phoneNumber.length - 4; i++ ) {
        star += '*';   
    }
    // *와 뒷 4자리 더한 값을 리턴합니다.
    return star + backFourNumber;
}
