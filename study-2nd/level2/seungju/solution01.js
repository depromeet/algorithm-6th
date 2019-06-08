function solution(s) {
    // Split string s with whitespace, then sort by numeric values
    const sortedNumbers = s.split(' ')
                            .sort((lhs, rhs) => lhs - rhs);
    
    // Since the array is sorted, take the first/last element
    const minimum = sortedNumbers.shift();
    const maximum = sortedNumbers.pop();

    return minimum + ' ' + maximum
}