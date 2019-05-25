function solution(brown, red) {
    let sum = brown + red;
    let divisorCouples = [];
    for(let i = Math.floor(Math.sqrt(sum)); i >= 1; i--) {
        if(sum % i === 0) {
            divisorCouples.push([sum / i, i]);
        }         
    }
    return divisorCouples.find(divisorCouple => {
        return (divisorCouple[0] + divisorCouple[1] - 2) * 2 === brown;
    });
}