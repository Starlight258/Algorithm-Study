class Solution {
    int answer = 0;
    int n;
    int[][] dungeonList;
    boolean[] visited;
    void play(int depth, int fatigue){
        answer = Math.max(answer, depth);
        for (int i=0;i<dungeonList.length;i++){
            if (!visited[i]){
                visited[i] = true;
                if (dungeonList[i][0] <= fatigue){
                    play(depth+1, fatigue - dungeonList[i][1]);                    
                }
                visited[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        dungeonList = dungeons;
        visited = new boolean[n];
   
        play(0, k);
        
        return answer;
    }
}