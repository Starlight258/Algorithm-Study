import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) times[0] * n;
        long mid = 0;
        while (left <= right){
            mid = left - (left-right)/2;
            long count = 0;
            for (int i=0;i<times.length;i++){
                count += mid / times[i];
            }
            if (count>=n){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}