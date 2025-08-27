import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] a = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        int n = citations.length;
        Arrays.sort(a, Collections.reverseOrder());
        int h = 0;
        for (int i=0;i<n;i++){
            if (a[i] >= i+1){
                h = i+1;
            } else break;
        }
        
        return h;
    }
    // 0 1 3 5 6
    // 6 5 3 1 0
    // 6 5 4 3 2 1 
}