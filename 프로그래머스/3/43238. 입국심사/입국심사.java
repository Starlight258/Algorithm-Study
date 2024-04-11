import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long start = 1;
        long mid = 0;
        Arrays.sort(times);
        long end = (long) times[0] * n;
        // 이진탐색 수행
        while (start<=end){
            long cnt = 0;
            mid = (start + end ) / 2;
            for (int i=0;i<times.length;i++){
                cnt += mid / times[i];
                if (cnt>n) break;
            }
            if (cnt < n){
                start = mid + 1;
            } else end = mid - 1;
        }
        return start;
    }
}