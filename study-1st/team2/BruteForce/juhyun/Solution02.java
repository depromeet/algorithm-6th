import java.util.HashSet;
import java.util.Set;

public class Solution02 {

    public static void main(String[] ar){
        String numbers = "1345";

//        System.out.println("result = "+ new Solution02().solution(numbers));

    }

    public int solution(String numbers) {
        int answer = 0;
        int max = 1000000;
        boolean a[] = new boolean[max];

        //numbers를 하나씩 쪼개어 넣어 둘 배열
        int[] arr = new int[numbers.length()];

        //조합을 통해 만들어 낼 숫자 리스트
        Set<Integer> numberList = new HashSet<>();

        int n = numbers.length();

        for(int i =0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i) - '0';
        }

        //조합순열을 통해 숫자 리스트 생성 구현해야함

        //소수를 찾아 배열에 저장
        findPrimeNum(a);

        //소수배열과 숫자배열 비교
        for(int i = 2; i<max; i++){
            if(a[i] && numberList.contains(i))
                answer++;
        }
        return answer;
    }

    public void findPrimeNum(boolean a[]){
        int max = 1000000;

        for(int i =2; i<max; i++)
            a[i] = true;

        for(int i =2; i<(int)Math.sqrt(max); i++){
            if(a[i] == true){
                for(int j = i; i*j < max; j++)
                    a[i*j] = false;
            }
        }
    }



}
