function solution(aList, bList) {
    
    // TODO: - Optimize for time performance
    const teamBScore = aList.reduce((sum, a) => {
        // -1 if index is not found
        const BThatWins = bList.filter((b) => b > a);
        const smallestBThatWins = Math.min(...BThatWins);
        const smallestBThatWinsIndex = bList.indexOf(smallestBThatWins);
        
        
        if (smallestBThatWinsIndex >= 0) {
            bList.splice(smallestBThatWinsIndex, 1);
            return sum + 1;
        } else {
            return sum;
        }
    }, 0)
    
    return teamBScore;
}