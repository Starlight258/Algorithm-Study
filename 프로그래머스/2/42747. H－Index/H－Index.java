import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int h = n;
        while (h>0){
            int count = 0;
            for (int c:citations){
                if (c>=h){
                    count++;
                }
            }
            if (count>=h && n-count<=h){
                return h;
            }
            h--;
        }
        return h;
    }
}