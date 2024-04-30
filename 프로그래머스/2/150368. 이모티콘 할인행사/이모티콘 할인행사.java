import java.util.*;
class Solution {
    int[] answer = new int[2];
    void dfs(int idx, int[][] users, int[] emoticons, int[] discount){
        if (idx==emoticons.length){
            int[] result = new int[2];
            
            for (int i=0;i<users.length;i++){
                int total = 0;
                for (int e=0;e<emoticons.length;e++){
                    if ((discount[e]*10) >= users[i][0]){
                        total += (int) emoticons[e] * (1.0 - 0.1 * discount[e]);
                    }
                }
                
                if (total >= users[i][1]){
                    result[0]++;
                } else {
                    result[1] += total;
                }
            }
            
            if (result[0] > answer[0]){
                    answer = result;
            } else if (result[0] == answer[0] && result[1] > answer[1]){
                    answer = result;
            }
            
            return;
        }
        
        for (int i=1;i<=4;i++){
            discount[idx] = i;
            dfs(idx+1, users, emoticons, discount);           
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        
        dfs(0, users, emoticons, discount);
        
        return answer;
    }
}