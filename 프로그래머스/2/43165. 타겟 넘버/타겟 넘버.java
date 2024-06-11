class Solution {
    int answer = 0;
    void dfs(int depth, int now, int[] numbers, int target){
        if (depth==numbers.length){
            if (target==now) answer++;
            return;
        }
        // + 선택
        dfs(depth+1, now+numbers[depth], numbers, target);
        // - 선택
        dfs(depth+1, now-numbers[depth], numbers, target);
    }
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
}