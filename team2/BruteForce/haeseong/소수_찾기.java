import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 소수_찾기 {

    public int solution(String numbers) {
        PrimeDiscriminator discriminator = PrimeDiscriminator.from(10000000);
        return (int) createAllNumbers(numbers)
                .stream()
                .filter(discriminator::isPrime)
                .count();
    }

    private Set<Integer> createAllNumbers(String number) {
        PermutationCalculator calculator = new PermutationCalculator();

        char[] characters = number.toCharArray();
        Set<Integer> numberSet = new HashSet<>();

        for (int i = 0; i < (2 << characters.length - 1); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < characters.length; j++) {
                if (((1 << j) & i) == 0) {
                    continue;
                }
                stringBuilder.append(characters[j]);
            }
            String candidate = stringBuilder.toString();
            if (candidate.length() == 0) {
                continue;
            }

            // permutation
            calculator.calculate(candidate.length(), candidate.toCharArray())
                    .stream()
                    .map(String::valueOf)
                    .map(Integer::valueOf)
                    .forEach(numberSet::add);
        }
        return numberSet;
    }

    /**
     * https://www.baeldung.com/java-array-permutations
     */
    public static class PermutationCalculator {

        public List<char[]> calculate(int length, char[] elements) {
            List<char[]> results = new ArrayList<>();
            addAllCandidates(length, elements, results);
            return results;
        }

        private void addAllCandidates(int n, char[] elements, List<char[]> results) {
            int[] indexes = new int[n];
            for (int i = 0; i < n; i++) {
                indexes[i] = 0;
            }

            add(elements, results);

            int i = 0;
            while (i < n) {
                if (indexes[i] < i) {
                    swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                    add(elements, results);
                    indexes[i] += 1;
                    i = 0;
                } else {
                    indexes[i] = 0;
                    i += 1;
                }
            }
        }

        private void swap(char[] input, int a, int b) {
            char tmp = input[a];
            input[a] = input[b];
            input[b] = tmp;
        }

        private void add(char[] chars, List<char[]> results) {
            char[] cloned = chars.clone();
            results.add(cloned);
        }
    }

    /**
     * '에라토스테네스의 체' 방식의 소수판별기
     */
    public static class PrimeDiscriminator {
        private static final int IS_PRIME_NUMBER = 0;
        private static final int IS_NOT_PRIME_NUMBER = 1;

        private final int size;
        private final int[] sheets;

        private PrimeDiscriminator(int size, int[] sheets) {
            this.size = size;
            this.sheets = sheets;
            initialize();
        }

        public static PrimeDiscriminator from(int size) {
            return new PrimeDiscriminator(size, new int[size]);
        }

        private void initialize() {
            int limit = (int) Math.sqrt(size) + 1;
            for (int i = 2; i < limit; i++) {
                for (int j = 2; i * j < size; j++) {
                    sheets[i * j] = IS_NOT_PRIME_NUMBER;
                }
            }
        }

        public boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            if (number >= size) {
                throw new IllegalArgumentException("'number' must be less than size(" + size + ").");
            }
            return sheets[number] == IS_PRIME_NUMBER;
        }
    }
}
