import java.util.*;

class Solution {
    
    private long answer = Long.MAX_VALUE;

    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = 100_000;
        
        while (left<=right){
            long mid =(right-left)/2 + left;
            boolean canCalculate = calculate(mid, diffs, times, limit);
            if (canCalculate){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return (int) answer;
    }
    private boolean calculate(long level, int[] diffs, int[] times, long limit){
        int prevTime = 0;
        long total = 0;
        for (int i=0;i<diffs.length;i++){
            int diff = diffs[i];
            int curTime = times[i];
            if (level >= diff){
                total += curTime;
            } else {
                total += (diff - level) * (curTime + prevTime) + curTime;         
            }
            prevTime = curTime;
        }
        if (total <= limit){
            answer = Math.min(answer, level);
            return true;
        }
        return false; // limit 넘은 경우
    }
    // diff <= level : time_cur만큼의 시간 사용
    // diff > level : (diff - level) * (time_cur +time_prev) + time_cur
    
    // (3-2) * (2+4) + 2
    // (3-2) * (2+4) + 2 = 8
    // (3-3) + 2 = 2;
    // 범위가 너무 큰데,, 설마 이분탐색은 아니겠지?
}