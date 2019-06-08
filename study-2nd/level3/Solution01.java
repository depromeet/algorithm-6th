class Solution01 {
    int result = 0;

    public long solution(int n) {
        jump(0, n);
        return result % 1234567;
    }

    private void jump(int distance, int n) {
        if (distance == n)
            result++;
        else if (distance < n) { // 아직 끝까지 가지 않았다면
            jump(distance + 1, n); // 현재 위치에서 1칸 점프
            jump(distance + 2, n); // 현재 위치에서 2칸 점프
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution01().solution(3));
    }
}