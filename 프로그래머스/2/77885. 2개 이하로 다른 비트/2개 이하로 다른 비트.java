import java.util.*;
class Solution {
    long findZeroIdx(long number){
        long idx=1;
        while (number>0){
            if (number%2==0){
                return idx;
            } 
            idx++;
            number /= 2;
        }
        return idx;
    }
    long makeAnswer(long number, long idx){
        for (int i=0;i<idx;i++){
            number += Math.pow(2, i);
        }
        return number;
    }
    public long[] solution(long[] numbers) {
        ArrayList<Long> answer = new ArrayList<Long>();
        for (long number:numbers){
            long returnValue = 0;
            long zeroIdx = findZeroIdx(number);
            if (zeroIdx<=2) {
                answer.add(number+1);
                continue;
            }
            answer.add(makeAnswer(number+1, zeroIdx-2));
        }
        return answer.stream().mapToLong(x->x).toArray();
    }
}