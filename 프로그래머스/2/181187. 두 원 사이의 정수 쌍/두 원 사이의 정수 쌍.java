import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x=0;x<r2;x++){
            double y1 = Math.sqrt((long)r2 * r2 - (long)x * x);
            double y2 = r1 > x ? Math.sqrt((long)r1 * r1 - (long) x * x) : 0;
            answer += (int) y1 - (int) y2;
            if (r1 > x && y2 - (int) y2 == 0.0){
                answer++; 
            }  
        }
        return answer * 4;
    }
}