import java.util.ArrayList;

public class Solution02 {

    public static void main(String[] args) {

        int[] priorities1 = {2,1,3,2};
        int[] priorities2 = {1,1,9,1,1,1};

        int location = 0;

        System.out.println("result = " + new Solution02().solution(priorities2,location));

    }

    class PrintInfo{
        int priority;
        int index;

        public PrintInfo(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int cursur = 0;

        ArrayList<PrintInfo> printList = new ArrayList<>();

        for(int i = 0; i<priorities.length; i++){
            PrintInfo printInfo = new PrintInfo(i, priorities[i]);
            printList.add(printInfo);
        }

        while(cursur < printList.size()){
            int first = printList.get(cursur).priority;

            for(int i = cursur+1; i<printList.size(); i++) {
                if (first < printList.get(i).priority) {
                    printList.add(printList.get(cursur));
                    printList.remove(printList.get(cursur));
                }
            }
            cursur ++;
        }

        for(int i = 0; i<printList.size(); i++){
            if(location == printList.get(i).index)
                return answer;
            answer++;
        }
        return answer;
    }
}
