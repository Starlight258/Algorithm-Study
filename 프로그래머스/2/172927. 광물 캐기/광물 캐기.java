import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
         int[][] fatigue = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
        };
        //1. 광물 5개씩 자르기
        int[][] mineralCnt = new int[(minerals.length+4)/5][3];
        int available = picks[0]*5+picks[1]*5+picks[2]*5;
        
        for (int i=0;i<Math.min(available, minerals.length);i++){
            switch (minerals[i]){
                case "diamond":
                    mineralCnt[i/5][0]++;
                    break;
                case "iron":
                    mineralCnt[i/5][1]++;
                    break;
                case "stone":
                    mineralCnt[i/5][2]++;
                    break;
            }
        }
        Arrays.sort(mineralCnt, (a, b) -> {
            if (a[0] == b[0] && a[1] == b[1]){
                return b[2] - a[2]; 
            } else if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return b[0] - a[0];
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
                if (picks[i]>0){
                    answer += minCnt[0]*fatigue[i][0];
                    answer += minCnt[1]*fatigue[i][1];
                    answer += minCnt[2]*fatigue[i][2];
                    picks[i]--;
                    break;
                }
            }
        }
     
        return answer;
    }
}