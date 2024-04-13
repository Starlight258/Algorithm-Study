class Solution {
    int answer = 0;
    void dfs(int idx,int sum, int[] numbers, int target){
        if (idx == numbers.length && sum == target){
            answer++;
            return;
        }
        if (idx==numbers.length) return;
        dfs(idx+1, sum+numbers[idx], numbers, target);
        dfs(idx+1, sum-numbers[idx], numbers, target);
    }
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        if (answer==0) return -1;
        return answer;
    }
}