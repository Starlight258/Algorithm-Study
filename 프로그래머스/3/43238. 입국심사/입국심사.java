import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long mid = 0;
        long end = (long) times[0] * n;
        // 이진탐색 수행
        while (start<=end){
            long cnt = 0;
            mid = start - (start - end) / 2;
            for (int i=0;i<times.length;i++){
                cnt += mid / times[i];
            }
            if (cnt >= n){
                end = mid - 1;
            } else start = mid + 1;
        }
        return start;
    }
}