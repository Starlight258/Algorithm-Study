class Solution {
    int answer = 0;
    int[] mark = {1, -1};
    void dfs(int[] numbers, int target, int idx, int sum){
        if (sum == target && idx == numbers.length-1){
            answer++;
            return;
        } else if (idx >= numbers.length-1) return;
        for (int i=0;i<2;i++){
            dfs(numbers, target, idx+1, sum+mark[i]*numbers[idx+1]);
        }
        
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, numbers[0]*-1);
        return answer;
    }
}