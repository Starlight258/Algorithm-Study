class Solution {
    private int[] answer = {-1};
    private int diff = 1;
    public int[] solution(int n, int[] info) {
        int[] result = new int[11];
        dfs(0, 0, 0, result, info, n, 0);
        return answer;
    }
    private void dfs(int depth, int score, int num, int[] result, int[] info, int n, int apeach){
        if (depth == info.length){
            if (diff <= score-apeach){   
                if (num != n){
                    result[depth-1] = n - num;
                }
                if (diff == score-apeach){
                    if (!checkResult(result, answer)) return;
                } 
                answer = result.clone();
                diff = score-apeach;
            }
            return;
        }
        // 맞출 경우
        if (num + info[depth]+1 <=n){
            result[depth] = info[depth]+1;
            dfs(depth+1, score+10-depth, num+info[depth]+1, result, info, n, apeach);
            result[depth] = 0;
        }
        // 맞추지 않을 경우
        if (info[depth]>0) apeach += 10-depth;
        dfs(depth+1, score, num, result, info, n, apeach);
    }
    
    private boolean checkResult(int[] result, int[] answer){
        if (answer.length==1) return true;
        for (int i=10;i>=0;i--){
            if (result[i]>answer[i]){
                return true;
            } 
            if (result[i]<answer[i]) return false;
        }
        return false;
    }
}

// 라이언이 가장 큰 점수차로 이기려면?
// 완전탐색 : 10점~0점까지 맞추는지, 안맞추는지
// 맞추려면 어피치 화살 + 1만큼 맞추기, n개 초과하면 break, 
// 정렬 -> 1. 점수 2. 낮은 점수 많이 맞춘 순 

// 10~5+2 vs 10~3 +0