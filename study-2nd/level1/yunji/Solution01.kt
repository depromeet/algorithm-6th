class Solution01 {
    fun solution(s: String): String {
        var answer = ""
        val wordUpper = s.toUpperCase()
        val wordLower = s.toLowerCase()

        var index = 0
        var lengthCount = 0
        while (lengthCount < s.length) {
            answer += if (index % 2 == 0) wordUpper[lengthCount] else wordLower[lengthCount]

            if (s[lengthCount] == ' ')
                index = -1

            index++
            lengthCount++
        }

        return answer
    }
}