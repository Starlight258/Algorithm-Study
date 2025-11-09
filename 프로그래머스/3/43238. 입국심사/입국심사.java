class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 1;
        long maxTime = 0;
        for (int time:times){
            maxTime = Math.max(maxTime, time);
        }
        long right = maxTime * n;
        
        while (left<=right){
            long mid = (left+right)>>>1;
            if (cal(mid, times)>=n){
                answer = Math.min(answer, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return answer;
    }
    
    private long cal(long mid, int[] times){
        long count = 0;
        for (int time:times){
            count += mid/time;
        }
        return count;
    }
    // 입국심사 기다리는 사람 n
    // 심사하는데 걸리는 시간 times
    // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값 
    // 0 -> 7 -> 14 -> 21
    // 0 -> 10 -> 20
    // dp? 근데 범위가 너무 큰데..? 이분탐색?
    // 28 = 7*4 , 10 * 2
    // 28/7 + 28/10 = 4+2 = 6 // 맞음
    // 파라메트릭서치? -> 시간
}