function solution(priorities, location) {
    const target = priorities[location];
    let count = 0;
    const samePriorityIndexs = [];
    const length = priorities.length;
    for(let i = 0; i < length; i++) {
        if(priorities[i] > target) {
            count++;
        } else if(priorities[i] === target) {
            samePriorityIndexs.push(i);
        }
    }
    
    let higherLastIndex = -1;
    for(let i = target + 1; i <= 9; i++) {
        higherLastIndex = priorities.lastIndexOf(i);
        if(higherLastIndex !== -1) {
            break;
        }
    }
    const sameHigherLastIndex = samePriorityIndexs.find(index => index > higherLastIndex);
    if(sameHigherLastIndex <= location) {
        count += sameHigherLastIndex - location + 1;
    } else {``
        count += samePriorityIndexs.length - sameHigherLastIndex + location + 2;
    }
    return count;  
}