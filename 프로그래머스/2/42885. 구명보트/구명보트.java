import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int fpos = 0; int lpos = people.length -1;
        while (fpos<lpos){
            int remain = limit - people[fpos];
            if (remain>=people[lpos]) {
                fpos++; lpos--;
            } else{
                lpos--;
            }
            answer++;
            if (fpos == lpos) answer++;
        }
        return answer;
    }
}