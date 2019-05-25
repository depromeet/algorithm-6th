function solution(answers) {
    let result = [];
    let patterns = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ];
    let scores = patterns.map(pattern => checkScore(answers, pattern));
    let maxScore = Math.max(...scores);
    for(let i = 0; i < scores.length; i++) {
        if(maxScore === scores[i]) {
            result.push(i+1);
        }
    }
    return result;
}
    
function checkScore(answers, pattern) {
    let score = 0;
    let patternLength = pattern.length;
    let answersLength = answers.length;
    for(let i = 0; i < answersLength; i++) {
        if(answers[i] === pattern[i % patternLength]) {
            score++;
        }
    }
    
    return score;
}