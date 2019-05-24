function solution(x, n) {
    // [1, 2, 3, ..., n] -> [1 * x, 2 * x, ..., n * x]
    return Array(n).fill().map((_, i) => (i + 1) * x)
}

