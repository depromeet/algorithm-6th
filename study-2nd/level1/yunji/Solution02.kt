class Solution02 {
    fun solution(n: Long): Long {
        var answer = 1L
        var multi = answer * answer

        while (multi <= n) {
            if (multi == n)
                return (answer + 1) * (answer + 1)

            answer++
            multi = answer * answer
        }

        return -1
    }
}