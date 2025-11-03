import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Integer, Integer> mp = new HashMap<>();
        // 하나씩 돌면서 존재하는지 확인
        for (int w:weights) {
            // 1:1
            if (mp.containsKey(w)){
                answer+=mp.get(w);
            }
            // 1:1/2
            if (w%2==0){
                answer+=mp.getOrDefault(w/2, 0);
            }
            // 1:2/3
            if (w%3==0){
                answer+=mp.getOrDefault(w/3*2, 0);
            }
            // 1:3/4
            if (w%4==0){
                answer+=mp.getOrDefault(w/4*3, 0);
            }
            mp.put(w, mp.getOrDefault(w,0)+1);
        }
        return answer;
    }
    // 2, 3, 4m
    // 100 : 100 -> 1:1 -> 최소공배수 100
    // 180 : 360 -> 1:2 -> 90 
    // 180 : 270 -> 2:3 -> 90 -> 1:3/2
    // 270 : 360 -> 3:4 -> 90 -> 1: 4/3
    
    
    // Set<Integer> : 포함하면 +1, O(n)
    // 작은것부터 추가
    // 1:1, 1:1/2, 1:2/3, 1:3/4
}