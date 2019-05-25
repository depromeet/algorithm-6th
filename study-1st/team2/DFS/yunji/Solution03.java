class Solution03 {
    boolean[] status;
    int answer;

    public int solution(String begin, String target, String[] words) {
        status = new boolean[words.length];
        checkWord(begin, target, words, 0);

        return answer;
    }

    public void checkWord(String word, String target, String[] words, int answer) {
        if (!word.equals(target)) {
            for (int i = 0; i < words.length; i++) {
                if (checkSpell(word, words[i])) {
                    if (!status[i]) {
                        status[i] = true;
                        checkWord(words[i], target, words, ++answer);
                    }
                }
            }
        } else
            this.answer = answer;
    }

    public static boolean checkSpell(String word, String target) {
        int checkSpell = 0;

        for (int i = 0; i < word.length(); i++) {
            if (target.charAt(i) != word.charAt(i))
                checkSpell++;

            if (checkSpell > 2)
                return false;
        }

        return (checkSpell == 1);
    }
}