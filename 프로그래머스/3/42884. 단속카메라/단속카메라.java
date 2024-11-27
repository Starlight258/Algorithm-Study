import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] visited = new boolean[routes.length];
        Arrays.sort(routes, (r1, r2)-> Integer.compare(r1[1], r2[1]));
        if (routes.length==1) return 1;
        
        for (int i=0;i<routes.length;i++){
            if (visited[i]) continue;
            visited[i] = true;
            int end = routes[i][1];
            answer++;
            while (i+1<routes.length && end >= routes[i+1][0]){
                visited[i+1] = true;
                i++;
            }
        }
        return answer;
    }
}