class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = 0;
        for (int time:times){
            right = Math.max(time, right);
        }
        right *= n;
        while (left <= right){
            long mid = (left + right) >>> 1;
            if (count(mid, times) >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    private long count(long mid, int[] times){
        long count = 0;
        for (int time : times){
            count += mid / time;
        }
        return count;
    }
    // 7(3) 10(4) 14(5) 20(6) + 10 vs 21 + 7(6)
    // 28 / 7 = 4;
    // 28 / 10 = 2;
    
    // 30 / 7 = 4
    // 30 / 10 = 3 
    
}