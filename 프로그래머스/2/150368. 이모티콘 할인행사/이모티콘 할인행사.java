import java.util.*;

class Solution {
    private int[] rate = {90, 80, 70, 60};
    private int totalSub = 0;
    private int totalCost = 0;
    
    private void dfs(int depth, int[] cost, int[][] users, int[] emoticons){
        if (depth == emoticons.length){
            int tsub = 0;
            int tcost = 0;
           for (int i=0;i<cost.length;i++){
                if (cost[i] >= users[i][1]){
                    tsub++;
                } else tcost += cost[i];
            } 
            if (totalSub <= tsub){
                if (totalSub==tsub && totalCost >= tcost){
                } else {
                    totalSub = tsub;
                    totalCost = tcost;
                }
            }
            return;
        }
        for (int i=0;i<rate.length;i++){
            int[] prev = new int[users.length];
            for (int j=0;j<users.length;j++){
                prev[j] = cost[j];
                if (users[j][0] <= (100-rate[i])){
                    cost[j] += emoticons[depth] * ((double)rate[i]/100);  
                }
            }
            dfs(depth+1, cost, users, emoticons);
             for (int j=0;j<users.length;j++){
                cost[j] = prev[j];
             }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[users.length], users, emoticons);
        return new int[]{totalSub, totalCost};
    }
}