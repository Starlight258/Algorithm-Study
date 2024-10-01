import java.util.*;

class Solution {
    private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int maxSubscribers = 0;
    private int maxRevenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxSubscribers, maxRevenue};
    }
    
    private void dfs(int depth, int[] discounts, int[][] users, int[] emoticons){
        if (depth == emoticons.length){
            calculateResult(discounts, users, emoticons);
            return;
        }
        
        for (int rate : DISCOUNT_RATES){
            discounts[depth] = rate;
            dfs(depth+1, discounts, users, emoticons);
        }
    }
    
    private void calculateResult(int[] discounts, int[][] users, int[] emoticons){
        int subscribers = 0;
        int revenue = 0;
        
        for (int[] user:users){
            int userMinDiscount = user[0];
            int userMaxCost = user[1];
            int totalCost = 0;
            
            for (int i=0;i<emoticons.length;i++){
                if (discounts[i]>= userMinDiscount){
                    totalCost += emoticons[i] * (100-discounts[i])/100;
                }
            }
            if (totalCost >= userMaxCost){
                subscribers++;
            } else {
                revenue += totalCost;
            }
        }
        if (subscribers > maxSubscribers || (subscribers==maxSubscribers && revenue >= maxRevenue)){
            maxSubscribers = subscribers;
            maxRevenue = revenue;
        }
    }
}