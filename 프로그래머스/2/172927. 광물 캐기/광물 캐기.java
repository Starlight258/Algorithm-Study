import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] fatigue = {
            {1,1,1},
            {5,1,1},
            {25,5,1}
        };
        int pickNum = 0;
        for(int i=0;i<picks.length;i++){
            pickNum += picks[i];
        }
        // 1. 5개씩 쪼개기
        int n = Math.min(pickNum*5, minerals.length);
        int[][] mineralDivision = new int[n/5+1][3];
        for (int i=0;i<n;i++){
            if (minerals[i].equals("diamond")){
                mineralDivision[i/5][0]++;
            }
            if (minerals[i].equals("iron")){
                mineralDivision[i/5][1]++;
            }
            if (minerals[i].equals("stone")){
                mineralDivision[i/5][2]++;
            }
        }
        // 2. 정렬하기
        Arrays.sort(mineralDivision, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[0]==o2[0]){
                    if (o1[1]==o2[1]){
                        return o2[2] - o1[2];
                    }
                    return o2[1]-o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        
        //3. 피로도 구하기
        int totalFatigue = 0;
        int pos = 0;
        for (int i=0;i<picks.length;i++){
            while (picks[i]>0 && pos<n/5+1){
                totalFatigue += fatigue[i][0] * mineralDivision[pos][0];
                totalFatigue += fatigue[i][1] * mineralDivision[pos][1];
                totalFatigue += fatigue[i][2] * mineralDivision[pos][2];
                picks[i]--;
                pos++;
            }
        }
        
        return totalFatigue;
    }
}