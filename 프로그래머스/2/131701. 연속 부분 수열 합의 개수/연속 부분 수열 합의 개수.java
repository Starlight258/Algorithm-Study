import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] prefix = new int[n * 2+1];
        Set<Integer> set = new HashSet<>();
        // 원소 하나
        for (int i=0;i<n;i++){
            prefix[i+1] = elements[i] + prefix[i];
            set.add(elements[i]);
        }
        for (int i=0;i<n;i++){
            prefix[i+1+n] = elements[i] + prefix[i+n];
        }
        // 연속 부분 수열
        for (int i=1;i<n;i++){
            for (int j=0;j<n;j++){
                set.add(prefix[i+j] - prefix[j]);
            }
        }
        // 전체 원소
        set.add(prefix[n]);
        return set.size();
    }
}