function solution(name) {
    var answer = 0;
    
    var alpha = String.fromCharCode(cuId);
    var base = alpha.repeat(name.length);
    var baseAll = base.toString().split("");
    
    var cuId = 65;
    
    window.addEventListener('keydown', handleKeyDown, false);
    function handleKeyDown(e) {
    if (e.keyCode === 37) {
        //왼쪽 화살표 - 배열의 왼쪽으로 이동
        }else if (e.keyCode === 39) {
        //오른쪽 화살표 - 배열의 오른쪽으로 이동
        }else{
            if (e.keyCode === 38) {
                //위쪽 화살표
                cuId--;
            }   
            if (e.keyCode === 40) {
                //아래쪽 화살표
                cuId++;
            }
        } 
    };
    
    answer = baseAll.join("");
    return answer;
}