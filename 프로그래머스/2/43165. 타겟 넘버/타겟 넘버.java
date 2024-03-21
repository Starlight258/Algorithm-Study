class Solution {
    int answer = 0;
    int[] mark = {1, -1};
    void dfs(int[] numbers, int target, int idx, int sum){
        if (idx == numbers.length){
            if (sum == target) answer++; 
            return;
        } 
        for (int i=0;i<2;i++){
            dfs(numbers, target, idx+1, sum+mark[i]*numbers[idx]);
        }
        
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
}