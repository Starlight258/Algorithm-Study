import java.util.*;
class Solution {
    public int solution(int[] ct) {
        //1. 정렬
        Arrays.sort(ct);
        //2. h-index 찾기
        int h = ct[ct.length-1];
        while (h>0){
            int count=0;
            for (int i=0;i<ct.length;i++){
                if (ct[i]>=h){
                    count++;
                }
            }
            if (count>=h) return h;
            h--;
         }
        
        return 0;
    }
}