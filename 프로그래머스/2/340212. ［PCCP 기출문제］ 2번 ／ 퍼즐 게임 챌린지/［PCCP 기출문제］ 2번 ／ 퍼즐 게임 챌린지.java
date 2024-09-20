class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int left = 1, right = 100000; // level
        while (left <= right){
            int mid = left + (right-left)/2;
            int prev = 0;
            long result = 0;
            for (int i=0;i<diffs.length;i++){
                if (diffs[i]<=mid){
                    result += times[i];
                } else if (diffs[i]>mid){
                    result += (diffs[i]-mid)*(times[i]+prev)+times[i];
                }
                
                if (result>limit) break;
                prev = times[i];
            }
            if (result <= limit){
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}