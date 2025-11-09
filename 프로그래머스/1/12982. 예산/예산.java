import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        int i = 0;
        while (i<d.length){
            sum += d[i++]; 
            if (sum>budget){
                break;
            }
            answer++;
        }
        return answer;
    }
    // 배열 d, 예산 budget
    // 최대 몇개의 부서에 물품 지원가능한지
    // 100_000 * 100 = 10_000_000 ; 천만..정렬해서 작은거 더하기?
}