import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("diamond", 0);
        hm.put("iron", 1);
        hm.put("stone", 2);
         int[][] fatigue = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
        };
        //1. 광물 5개씩 자르기
        int[][] mineralCnt = new int[minerals.length/5+1][3];
        int available = picks[0]*5+picks[1]*5+picks[2]*5;
        for (int i=0;i<minerals.length;i++){
            if (i>=available) break;
            mineralCnt[i/5][hm.get(minerals[i])]++;
        }
        Arrays.sort(mineralCnt, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0] && a[1] == b[1]){
                    return b[2] - a[2]; 
                } else if (a[0] == b[0]){
                    return b[1] - a[1];
                }
                return b[0] - a[0];
            }
        });
        // 곡괭이 고르기
        int pickPos = 0;
        for (int i=0;i<picks.length;i++){
            if (picks[i]>0){
                pickPos = i;
                break;
            } 
        }
        for (int[] minCnt:mineralCnt){
            for (int i=0;i<3;i++){
                answer += minCnt[i]*fatigue[pickPos][i];                
            }
            picks[pickPos]--;
            while (picks[pickPos]<=0){
                pickPos++;
                if (pickPos>=picks.length) return answer;
            }
        }
     
        return answer;
    }
}