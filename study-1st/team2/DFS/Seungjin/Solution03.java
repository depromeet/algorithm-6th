import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.lang.Math;
import java.util.Queue;

class index_log {
    int index;
    long log;
    int count;

    public index_log(int index, long log, int count){
        this.index = index;
        this.log = log;
        this.count = count;
    }

}

class Solution {
    static long DropTheBit(int b){int a = 1; b++; return (a << (b-1));}

    public int solution(String begin, String target, String[] words){
//    public static void main(String[] args){
//        String begin = "hit";
//        String target = "cog";
//        String words[] = {"hot","dot","dog","lot","log","cog"};

        
        int MAX = 9999999;

        int min = MAX;
        int can_change_number = begin.length()-1;
        long []  ok_next_flag = new long[words.length]; // ok_flag & index = 1 --> next_ok
        long ok_target_flag = 0; // ok_flag & index - 1 --> ok
        long ok_begin_flag = 0;
        int target_index = -1;
        Arrays.fill(ok_next_flag,0);

        for(int i = 0; i< words.length; i++){
            
            for(int j=i; j<words.length; j++){
                int compare = 0;
                int compare_begin= 0;
                int compare_target = 0;

                for(int k=0; k<words[i].length(); k++){
                    if(words[i].charAt(k) == words[j].charAt(k))
                        compare++;
                    
                    if(words[i].charAt(k) == begin.charAt(k))
                        compare_begin++;

                    if(words[i].charAt(k) == target.charAt(k))
                        compare_target++;
                        
                }
                
                if(compare_begin == can_change_number)
                    ok_begin_flag = ok_begin_flag | DropTheBit(i);

                if(compare_target == can_change_number)
                    ok_target_flag = ok_target_flag | DropTheBit(i);
                
                else if(compare_target == target.length()) {
                	target_index = i;
                }


                if(compare == can_change_number){
                    ok_next_flag[i] = ok_next_flag[i] | DropTheBit(j);
                   // System.out.println(Long.toBinaryString(ok_next_flag[i]));
                    ok_next_flag[j] = ok_next_flag[j] | DropTheBit(i);
                    //System.out.println(Long.toBinaryString(ok_next_flag[j]));
                }

            }





        }



        Queue<index_log> tree = new LinkedList<index_log>();
        for(int i=0; i<words.length; i++)
            if((ok_begin_flag & DropTheBit(i)) > 0 && i != target_index && target_index != -1)
                tree.add(new index_log(i,DropTheBit(i),1)); //Index, Log, count

        
        while(!tree.isEmpty()){
            index_log now = tree.poll();

            //if((ok_target_flag & DropTheBit(now.index)) > 0){
            //if((ok_next_flag[target_index] & DropTheBit(now.index)) > 0) {
            if(now.index == target_index){
                min = min > now.count ? now.count : min;
                break;
            }


            for(int i=0; i<words.length; i++){
                if((ok_next_flag[i] & DropTheBit(now.index)) > 0){
                    if((now.log & DropTheBit(i))>0);
                    else  tree.add(new index_log(i,now.log | DropTheBit(i), now.count+1));
                }
            }
        }
        
        if(min == MAX)
        	min = 0;


        //System.out.println(min);
        return min;
    }
}
