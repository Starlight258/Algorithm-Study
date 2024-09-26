import java.util.*;

class Solution {
    int[][] fatigue = {
        {1,1,1},
        {5,1,1},
        {25,5,1}
    };
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        int totalPicks = 0;
        for (int pick:picks){
            totalPicks += pick;
        }
        for (int i=0;i<minerals.length/5+1 && i<totalPicks;i++){
            int dia = 0, iron = 0, stone = 0;
            for (int j=0;j<5 && i*5+j<minerals.length;j++){
                switch(minerals[i*5+j]){
                    case "diamond":
                        dia++;
                        break;
                    case "iron":
                        iron++;
                        break;
                    case "stone":
                        stone++;
                        break;
                }
            }
            list.add(new int[]{dia, iron, stone});
        }
        // 리스트 정렬하기
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0]){
                    if (a[1] == b[1]){
                        return Integer.compare(b[2], a[2]);
                    }
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(b[0], a[0]);
            }
        });
        
        // 곡괭이로 깨뜨리기
        int pos = 0;
        for (int i=0;i<picks.length;i++){
            int pick = picks[i];
            while (pick>0){
                if (pos>=list.size()) break;
                answer += fatigue[i][0] * list.get(pos)[0];
                answer += fatigue[i][1] * list.get(pos)[1];
                answer += fatigue[i][2] * list.get(pos)[2];
                pos++; 
                pick--;
            }  
        }
    
        return answer;
    }
}