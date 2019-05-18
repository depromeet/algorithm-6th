import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.lang.Math;

class Solution {
    static int baseLog(int x, int base) {return (int)(Math.log10(x) / Math.log10(base));}
    static int Left(int a){return 2*a;}
    static int Right(int a){return 2*a+1;}
    static int GetLayer(int a){return baseLog(a, 2);}
    
    int solution(int [] numbers, int target) {
        Stack<Integer> tree = new Stack<Integer>();
        int MAX_NUMBER = (int)(Math.pow(2, numbers.length+1)+1);
        System.out.println(MAX_NUMBER);
        int answer = 0;
        int [] dp = new int[MAX_NUMBER+1];
        Arrays.fill(dp, 0);
        
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = numbers[0]; //LEFT
        dp[3] = -numbers[0]; //RIGHT
        
        tree.push(2);
        tree.push(3);

        while(!tree.empty()){
            int pop_index = tree.pop();

            if(Right(pop_index) <= MAX_NUMBER-1){
                dp[Left(pop_index)] = (dp[pop_index] + numbers[GetLayer(Left(pop_index))-1]);
                dp[Right(pop_index)] = (dp[pop_index] - numbers[GetLayer(Right(pop_index))-1]);
                tree.push(Left(pop_index));
                tree.push(Right(pop_index));
            }

            else{
                if(dp[pop_index] == target){
                    answer++;
                    System.out.println(answer);
                }
            }
        }

        return answer;


    }
}
