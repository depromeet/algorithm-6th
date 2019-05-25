import java.util.Arrays;

class Solution04 {

    static public void main(String args[]){

        int result[] = new int[2];
        int brown = 24;
        int red = 24;

        result = new Solution04().solution(brown,red);

        System.out.println(Arrays.toString(result));

    }

    public int[] solution(int brown, int red) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;

        for (int i = 1; i <= red; i++)
        {
            if (red % i == 0) {
                x = red/i;
                y = i;
                if((2*(x+2)+2*y) == brown){
                    answer[0] = y+2;
                    answer[1] = x+2;
                }
            }
        }
        return answer;
    }
}
