import java.util.LinkedList;
import java.util.Queue;

public class Network {
	public static int solution(int n, int[][] computers) {
		int[] visited = new int[n];
		int count = 1;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0 ; i < n ; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				visited[i] = count;
				
				
				while (!queue.isEmpty()) {
					int v = queue.poll();
					for (int j = 0 ; j < n ; j++) {
						if (computers[v][j] == 1 && visited[j] == 0) {
							queue.add(j);
							visited[j] = count;
						}
					}
				}
				
				count++;
			}
			
			
			
		}
		
		
		
		
		return count;
	}
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		int answer = solution(n, computers);
		
		System.out.println(answer - 1);
		
	}
}

