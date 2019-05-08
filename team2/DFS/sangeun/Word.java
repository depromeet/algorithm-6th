import java.util.LinkedList;
import java.util.Queue;

public class Word {
	public static int compareWords(String A, String B) {
		int counts = 0;
		for (int i = 0 ; i < A.length() ; i++) {
			if (A.charAt(i) != B.charAt(i)) {
				counts++;
			}
			if (counts > 1) {
				return 2;
			}
		}
		if (counts == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public static int solution(String begin, String target, String[] words) {
		
		Queue<Integer> queue = new LinkedList<>();
		int[][] map = new int[words.length][words.length];
		int[] visited = new int[words.length];
		
		int count = 0;
		for (int i = 0 ; i < words.length ; i++) {
			if (compareWords(begin, words[i]) == 1) {
				queue.add(i);
				count = 1;
				visited[i] = count;
				break;
			}
		}
		if (count == 0) {
			return count;
		} else {
			for (int i = 0 ; i < words.length ; i++) {
				for (int j = 0 ; j < words.length ; j++) {
					if (i == j) {
						continue;
					} else {
						if (compareWords(words[i], words[j]) == 1) {
							map[i][j] = 1;
							map[j][i] = 1;
						}
					}
				}
			}
			
//			for (int i = 0 ; i < words.length ; i++) {
//				for (int j = 0 ; j < words.length ; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			while (!queue.isEmpty()) {
				int v = queue.poll();
				
				for (int i = 0 ; i < words.length ; i++) {
					
					if (map[v][i] == 1 && visited[i] == 0) {
						queue.add(i);
						visited[i] = visited[v] + 1;
					}
				}
			}
		}
		
		for (int i = 0 ; i < words.length ; i++) {
			if (compareWords(target, words[i]) == 0) {
				return visited[i];
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin, target, words));
		
	}
}

