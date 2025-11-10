import java.util.*;

class Solution {
    
    private int n;

    public int solution(int[] stones, int k) {
        int answer = 0;
        int dCount = Integer.MAX_VALUE;
        n = stones.length;
        int left = 0;
        int right = 0;
        for (int i=0;i<n;i++){
            right = Math.max(right, stones[i]);
        }
        
        if (!canCross(0, stones, k)){
            return answer;
        }; 
        
        while (left<=right){
            int mid = (right-left)/2 + left;
            if (canCross(mid, stones, k)){
                answer = Math.max(answer, mid);
                left = mid+1; // 더 늘리기
            } else {
                right = mid-1;
            }
        }
        return answer+1;
    }
    
    private boolean canCross(int mid, int[] stones, int k){
        int cons = 0;
        int maxCons = 0;
        
        for (int i=0;i<n;i++){
            if (stones[i]<=mid){
                cons++;
            } else {
                maxCons = Math.max(maxCons, cons);
                cons = 0;
            }
        }
        maxCons = Math.max(maxCons, cons);
        
        if (maxCons>=k){
            return false;
        }
        
        return true;
    }
    // 한번 밟을때마다 디딤돌 숫자 -1
    // 0이 되면 더이상 밟을 수 없음, 그 다음으로 건너뜀
    // 왼 -> 오, 한 사람씩 건너기 시작
    // 200만개의 돌, 2억 값
    // 한번에 건너뛸 수 있는 디딤돌의 최대 칸 수 k, 최대 몇 명까지 징검다리?
    // 무제한 * 200만개의 돌... 
    // 무사히 건너려면 -> 우선 인원수만큼 줄이면서, 연속 0이 k개이면 그 전이 답
    // 1. 최소 숫자 구하기 -> 최소 인원수
    // 2. 그 다음 최소 숫자 구하기 -> 그것보다 작은 숫자가 k-1개 있어야함 
    // 이분탐색 -> 연속 개수가 k보다 크면 삭제할 숫자 줄이기
}