class Solution {
    int answer = 0;
    boolean[] visited;
    void play(int depth, int fatigue, int[][] dungeons){
        answer = Math.max(answer, depth);
        for (int i=0;i<dungeons.length;i++){
            if (!visited[i]){
                visited[i] = true;
                if (dungeons[i][0] <= fatigue){
                    play(depth+1, fatigue - dungeons[i][1], dungeons);                    
                }
                visited[i] = false;
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
   
        play(0, k, dungeons);
        
        return answer;
    }
}