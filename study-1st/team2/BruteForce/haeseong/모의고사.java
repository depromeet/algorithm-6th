import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 모의고사 {

    public int[] solution(int[] answers) {
        List<Integer> answerList = IntStream.of(answers)
                .boxed()
                .collect(Collectors.toList());

        int firstScore = Student.FIRST.solve(answerList);
        int secondScore = Student.SECOND.solve(answerList);
        int thirdScore = Student.THIRD.solve(answerList);

        int maxScore = Math.max(firstScore, Math.max(secondScore, thirdScore));

        List<Integer> results = new ArrayList<>();
        if (firstScore == maxScore) {
            results.add(Student.FIRST.getNumber());
        }
        if (secondScore == maxScore) {
            results.add(Student.SECOND.getNumber());
        }
        if (thirdScore == maxScore) {
            results.add(Student.THIRD.getNumber());
        }
        return results.stream()
                .mapToInt(i -> i)
                .toArray();
    }


    public enum Student {
        FIRST(1, Pattern.of(1, 2, 3, 4, 5)),
        SECOND(2, Pattern.of(2, 1, 2, 3, 2, 4, 2, 5)),
        THIRD(3, Pattern.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        private Integer number;
        private Pattern pattern;

        Student(Integer number, Pattern pattern) {
            this.number = number;
            this.pattern = pattern;
        }

        public Integer getNumber() {
            return number;
        }

        public int solve(List<Integer> problems) {
            return (int) problems.stream()
                    .filter(problem -> pattern.getAnswer().equals(problem))
                    .count();
        }
    }

    public static class Pattern {
        private final List<Integer> answers;
        private final int size;
        private int current;

        private Pattern(List<Integer> answers, int size, int current) {
            this.answers = answers;
            this.size = size;
            this.current = current;
        }

        public static Pattern of(int... numbers) {
            List<Integer> answers = IntStream.of(numbers)
                    .boxed()
                    .collect(Collectors.toList());
            return new Pattern(answers, answers.size(), 0);
        }

        public Integer getAnswer() {
            Integer answer = answers.get(current);
            current = (current + 1) % size;
            return answer;
        }
    }
}
