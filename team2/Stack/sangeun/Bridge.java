import java.util.*;

class B2 {
	int truck_weight;
	int level;
	public B2(int truck_weight) {
		// TODO Auto-generated constructor stub
		this.truck_weight = truck_weight;
		this.level = 1;	// 생성 후 큐에 바로 들어가기 때문에 경과 시간 1로 초기화
	}
}
public class Bridge {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<B2> queue = new LinkedList<>();
        
        int count = 0;			// 경과 시간 
        int current_weight = 0;	// 다리의 현재 무게
        int next_truck = 0;		// 대기중인 트럭 index 
        boolean flag = true;		// 마지막 트럭까지 다리에 진입했을 경우 flag값 false 
        
        while (true) {
        		count++;				// while문이 한 번 돌면 1 time의 시간 경과 
        		if (!flag && queue.isEmpty()) {	// 마지막 트럭이 빠져나왔을 경우
        			break;						// 반복문을 빠져나옴 
        		}
        		// 현재 다리 위에 있는 트럭들의 level 증가 
        		Iterator<B2> iter = queue.iterator();
        		while (iter.hasNext()) {
        			B2 temp = iter.next();
        			temp.level++;
        		}
        		// 대기중인 트럭이 있고, 다리에 여유가 있을 때 트럭 입장
        		if (next_truck < truck_weights.length && current_weight + truck_weights[next_truck] <= weight) {
    				current_weight += truck_weights[next_truck];
    				queue.add(new B2(truck_weights[next_truck++]));
    				// 마지막 트럭일 경우 flag false로 set
        			if (next_truck == truck_weights.length) {
        				flag = false;
        			}
        		}
        		// 트럭이 다리를 다 지나가서 빠져나갈 경우 
        		if (queue.peek().level == bridge_length) {
        			B2 temp = queue.poll();
        			// poll 이후 현재 다리 무게에서 빠져나간 트럭 무게 -
        			current_weight -= temp.truck_weight;
        		}       	
        }        
        return count;
    }
	
	public static void main(String[] args) {
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int bridge_length = 100;
		int weight = 100;
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}

