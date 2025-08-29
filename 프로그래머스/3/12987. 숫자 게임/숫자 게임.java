import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Integer[] aBox = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] bBox = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(aBox, Collections.reverseOrder());
        Arrays.sort(bBox, Collections.reverseOrder());
        
        int bIndex = 0;
        for (int i=0;i<aBox.length;i++){
            int a = aBox[i];
            int b = bBox[bIndex];
            if (a<b){
                bIndex++;
                answer++;
            } 
        }
        return answer;
    }
    // 5 1 3 7 -> 1 3 5 7 | 7 5 3 1
    // 6 2 2 8 -> 2 2 6 8 | 6 6 2 2
    // 점수차가 적으면서 더 큰 수 
    // 1 2 2 4
    // 2 3 4 5
    // 1. 내림차순 정렬 
    // 2. B[i1] > A[i2] : i1++; i2++; result++;
    // B[i1] <= A[i2] : i2++;
    // i2가 끝이면, 종료 
}