public class 카펫 {

    public int[] solution(int brown, int red) {
        int candidate = 0;
        for (int i = 1; i < 5000; i++) {
            if (doesSatisfy(i, brown, red)) {
                candidate = i;
                break;
            }
        }
        int theOther = getTheOther(candidate, brown);

        return candidate >= theOther
                ? new int[]{candidate, theOther}
                : new int[]{theOther, candidate};
    }

    // ((brown + 4) / 2) * x - x^2 = brown + red
    private boolean doesSatisfy(int candidate, int brown, int red) {
        int left = ((brown + 4) / 2) * candidate - candidate * candidate;
        int right = brown + red;
        return left == right;
    }

    // y = ((brown + 4) / 2) - x
    private int getTheOther(int candidate, int brown) {
        return (brown + 4) / 2 - candidate;
    }
}
