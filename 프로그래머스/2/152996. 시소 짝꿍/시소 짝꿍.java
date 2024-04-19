import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        double[] multiplyNum = {1, 2.0/3, 1.0/2, 3.0/4}; 
        Arrays.sort(weights);
        HashMap<Double, Double> mp = new HashMap<>();
        for (double weight:weights){
            for (int j=0;j<4;j++){
                if (mp.containsKey(weight * multiplyNum[j])){
                    answer += mp.get(weight * multiplyNum[j]);
                }
            }
            mp.put(weight, mp.getOrDefault(weight, 0.0) + 1);
        }
        return answer;
    }
}