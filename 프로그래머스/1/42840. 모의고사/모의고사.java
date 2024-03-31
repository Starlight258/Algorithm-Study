import java.util.*;
class Solution {
    public int[] solution(int[] answer) {
        ArrayList<Integer> answerList = new ArrayList<>();
        int pattern[][] = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        int[] cnt = new int[3];
        for (int i=0;i<answer.length;i++){
            for (int j=0;j<3;j++){
                if (answer[i] == pattern[j][i % pattern[j].length]){
                    cnt[j]++;
                }
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