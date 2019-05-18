function solution(arrangement) {
    let stackSize = 0;
    let arrLength = arrangement.length;
    let numStick = 0;
    for(let i = 0; i < arrLength; i++) {
        if(arrangement[i] === '(') {
            if(arrangement[i + 1] === ')') {
                // lazer
                numStick += stackSize;
                i++;
            } else {
                stackSize++;                
            }
        } else {
            stackSize--;
            numStick++;
        }
    }

    return numStick;
}
