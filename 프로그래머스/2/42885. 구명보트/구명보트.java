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
            } else { // 20,30,50,70, 90
                lpos--; // 30, 30, 30 // 90
            }
            answer++;
            if (fpos == lpos) answer++;
        }
        return answer;
    }
}