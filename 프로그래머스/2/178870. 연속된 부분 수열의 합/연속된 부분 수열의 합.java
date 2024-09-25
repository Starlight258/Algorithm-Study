import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] answer = {0, n-1};
        int sum = 0;
        int left =0, right= 0;
        while (right < n){
            sum += sequence[right];
            
            while (sum > k && left <= right){
                sum -= sequence[left++];
            }
            if (sum==k){
                if (right - left < answer[1]-answer[0]){
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
        }

        return answer;
    }
}