class Solution01 {
    int target, height, answer = 0;

    public int solution(int[] numbers, int target) {
        Node root = new Node(0);
        this.target = target;
        this.height = numbers.length;

        initTree(root, numbers, 0);
        traverseTree(root, 0, 0);

        return answer;
    }

    public void traverseTree(Node current, int sum, int index) {
        if (current != null) {
            sum += current.value;
            if (index == height && sum == target)
                answer++;

            index++;
            traverseTree(current.left, sum, index);
            traverseTree(current.right, sum, index);
        }
    }

    // 순회할 트리 초기화
    public void initTree(Node current, int[] numbers, int index) {
        current.left = new Node(numbers[index]);
        current.right = new Node(numbers[index] * -1);

        index++;
        if (index < numbers.length) {
            initTree(current.left, numbers, index);
            initTree(current.right, numbers, index);
        }
    }

    class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}