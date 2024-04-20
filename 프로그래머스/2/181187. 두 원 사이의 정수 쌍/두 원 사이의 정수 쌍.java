import java.util.*;
class Solution {
    long onCircle = 0;
    long calculateNum(int r){
        long result = 0;
        for (int x=0;x<r;x++){
            double y = Math.sqrt(Math.pow(r, 2)- Math.pow(x, 2));
            if (y - (int) y == 0.0){
                onCircle++; 
            }  
            result += (int) y;
        }
        return result;
    } 
    public long solution(int r1, int r2) {
        long answer = 0;
        answer += calculateNum(r2);
        onCircle = 0;
        answer -= calculateNum(r1);
        answer += onCircle;
        return answer * 4;
    }
}