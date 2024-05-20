class Solution {
    int[] result = new int[11];
    int[] answer = {-1};
    int diffMax = 0;
    void dfs(int depth, int n, int[] info){
        if (depth==n){
            int diff = getDiff(result, info);
            if (diff >= diffMax){
                diffMax = diff;
                answer = result.clone();
            }
            return;
        }
        // 모든 경우의 수 구하기
        for (int i=0;i<info.length;i++){
            if (result[i]>info[i]) break;
            result[i]++;
            dfs(depth+1, n, info);
            result[i]--;
        }
    }
    
    int getDiff(int[] result, int[] info){
        int lScore = 0, aScore=0;
        for (int i=0;i<info.length;i++){
            if (info[i] >= result[i]){
                if (info[i] == 0) continue;
                aScore += (10-i);
            }
            else lScore += (10-i);
        }
        return lScore - aScore;
    }
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        
        if (diffMax==0) return new int[]{-1};
        
        return answer;
    }
}