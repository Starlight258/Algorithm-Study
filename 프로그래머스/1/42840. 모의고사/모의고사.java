import java.util.*;
class Solution {
    public int[] solution(int[] answer) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        int[] pos = new int[3];
        int[] cnt = new int[3];
        int cnt1=0, cnt2=0, cnt3 = 0;
        for (int i=0;i<answer.length;i++){
            pos[0] = pos[0]>=p1.length ? 0 : pos[0];
            pos[1] = pos[1]>=p2.length ? 0 : pos[1];
            pos[2] = pos[2]>=p3.length ? 0 : pos[2];
 
            if (answer[i] == p1[pos[0]]){
                cnt[0]++;
            } 
            if(answer[i] == p2[pos[1]]){
                cnt[1]++;
            }
            if (answer[i] == p3[pos[2]]){
                cnt[2]++;
            }
            pos[0]++; pos[1]++; pos[2]++;
        }
        // 3 원소 크기 비교
        int maxCnt = 0;
        for (int i=0;i<3;i++){
            maxCnt = Math.max(maxCnt, cnt[i]);
        }
        for (int i=0;i<3;i++){
            if (maxCnt == cnt[i]){
                answerList.add(i+1);
            }
        }
        return answerList.stream().mapToInt(x->x).toArray();
    }
}