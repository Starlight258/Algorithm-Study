import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int n = people.length;
        int left = 0, right = n-1;
        while (left <= right){
            if (people[left] + people[right] <=limit){
                answer++;
                left++; right--;
                continue;
            } 
            answer++;
            right--;
        }
        
        return answer;
    }
    // 20 50 50 70 80
    // (20 + 80) (50, 50) (70)
    // (20 + 50) (50) (70) (80)
    // a + b = limit -> b = limit - a
    // 작은 것부터 순회 돌면서 limit - a인 가장 큰 숫자끼리 visited, count
}