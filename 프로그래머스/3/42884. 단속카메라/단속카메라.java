import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //1. 끝점 기준 내림차순 정렬
        Arrays.sort(routes, (o1,o2)->{
            return o1[1] - o2[1]; 
        });
        //2. 끝점 기준 
        int end = routes[0][1];
        if (routes.length==1) return 1;
        for (int i=1;i<routes.length;i++){
            if (end>=routes[i][0]) continue;
            answer++;
            end = routes[i][1];
        }
    
        return answer+1;
    }
}