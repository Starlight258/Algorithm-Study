import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left =1;
        int right = distance;
        Arrays.sort(rocks);
        while (left<=right){
            int mid = (right-left)/2 +left;
            if (canCross(mid, rocks, n, distance)){
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    private boolean canCross(int mid, int[] rocks, int n, int distance){
        int count = 0;
        int prev = 0;
        for (int i=0;i<rocks.length;i++){
            if (count > n){
                return false;
            }
            if (rocks[i]-prev <mid){
                count++;
                continue;
            }
            prev = rocks[i];
            
        }
        if (distance - prev<mid) count++;
         if (count > n){
            return false;
        }
        return true;
    }
    
    // 돌과의 거리 최솟값 
    // 정해서 만약 거리의 최솟값보다 크면 제거, 2개 이상이면 종료 
}