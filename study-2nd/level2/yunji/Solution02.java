import java.util.*;

public class Solution02 {
    public static boolean solution(String[] phoneBook) {
        List<String> phoneNums = new ArrayList<>(Arrays.asList(phoneBook));
        Collections.sort(phoneNums, Comparator.comparingInt(String::length));

        for (int i = 0; i < phoneNums.size(); i++) {
            for (int j = i + 1; j < phoneNums.size(); j++) {
                String num = phoneNums.get(i);
                if (phoneNums.get(j).substring(0, num.length()).equals(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}