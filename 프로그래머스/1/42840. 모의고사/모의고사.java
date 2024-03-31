import java.util.*;
class Solution {
    public int[] solution(int[] answer) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3];
        for (int i=0;i<answer.length;i++){
            if (answer[i] == p1[i % p1.length]){
                cnt[0]++;
            } 
            if(answer[i] == p2[i % p2.length]){
                cnt[1]++;
            }
            if (answer[i] == p3[i % p3.length]){
                cnt[2]++;
            }
        }
        // 3 원소 크기 비교
        int maxCnt = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        for (int i=0;i<3;i++){
            if (maxCnt == cnt[i]){
                answerList.add(i+1);
            }
        }
        return answerList.stream().mapToInt(x->x).toArray();
    }
}