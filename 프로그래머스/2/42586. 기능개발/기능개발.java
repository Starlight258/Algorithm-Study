import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int lastDay = 0;
        int count = 0;
        for (int i=0;i<progresses.length;i++){
            int remain = 100 - progresses[i];
            int s = speeds[i];
            int day = remain / s;
            if (remain % s !=0){
                day++;
            }
            if (i!=0 && lastDay<day) {
                answer.add(count);
                count = 1;
            } else {
                count++;
            }
            lastDay = Math.max(lastDay, day);
        }
        if (count!=0){
            answer.add(count);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
    // 3 7
    // 7 3 9 -> 7 7 9
    // 5 10 1 1 20 1 -> 5 10 10 10 20 20
    // 1. 기능 작업 일수 계산
    // 2. a>b일 경우 a로 count후 answer에 저장
}