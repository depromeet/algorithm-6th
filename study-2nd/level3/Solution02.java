import java.util.*;

public class Solution02 {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] visitCount = new int[n + 1];

        Graph graph = new Graph(n);
        for (int[] ints : edge) { // 그래프 초기화
            graph.put(ints[0], ints[1]);
        }

        queue.add(1); // 시작점은 1번 노드
        while (queue.size() > 0) {
            int queueVal = queue.poll();
            for (Integer nearNode : graph.getNode(queueVal)) {
                if (visitCount[nearNode] == 0) { // 아직 방문한 적이 없다면
                    visitCount[nearNode] = visitCount[queueVal] + 1; // 이전 노드까지의 거리에서 + 1
                    queue.add(nearNode); // 큐에 노드 추가
                }
            }
        }

        int max = 0;
        for (int i = 2; i < visitCount.length; i++) { // 가장 먼 노드 개수 세기
            if (visitCount[i] > max) { // 더 멀리있는 노드를 찾았을 때
                max = visitCount[i];
                answer = 1;
            } else if (visitCount[i] == max) {
                answer++;
            }
        }

        return answer;
    }

    class Graph {
        private List<List<Integer>> graph;

        public Graph(int size) {
            this.graph = new ArrayList<>();
            for (int i = 0; i < size + 1; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public List<Integer> getNode(int x) {
            return this.graph.get(x);
        }

        public void put(int x, int y) {
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
}
