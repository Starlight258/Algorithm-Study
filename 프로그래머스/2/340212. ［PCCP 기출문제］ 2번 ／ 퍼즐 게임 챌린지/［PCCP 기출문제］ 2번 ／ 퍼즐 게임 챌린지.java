class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int[] prefix = new int[diffs.length+1];
        for (int i=0;i<times.length;i++){
            prefix[i+1] = prefix[i] + times[i]; 
        }
        
        // 이진탐색
        int left = 1; int right = 100_000;
        while (left<=right){
            int mid = (left + right)/2;
            if (calculateTime(diffs, prefix, limit, mid)){
                right = mid-1; // 최소시간 구하기
                answer = Math.min(answer, mid);
            } else left = mid+1;
        }
        return answer;
    }
    
    private boolean calculateTime(int[] diffs, int[] prefix, long limit, int level){
        long total = 0;
        for (int i=0;i<diffs.length;i++){
            int diff = diffs[i];
            if (diff<=level){
                total += prefix[i+1] - prefix[i];
            } else {
                if (i==0) total += (diff-level) * prefix[i+1] + prefix[i+1];
                else total += (diff-level) * (prefix[i+1]-prefix[i-1]) + (prefix[i+1]-prefix[i]);
            }
        }
        return total <= limit;
    }
}