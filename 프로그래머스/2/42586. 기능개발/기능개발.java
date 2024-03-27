import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        // 요일 계산
        for (int i=0;i<progresses.length;i++){
            int remains = 100 - progresses[i];
            int day = remains / speeds[i];
            if ((remains % speeds[i]) != 0){
                day++;
            }
            q.offer(day);
        }
        while (!q.isEmpty()){
            int n  = 1;
            int value = q.poll();
            while (!q.isEmpty() && value >= q.peek()){
                q.poll();
                n++;
            }
            answer.add(n);
        }
        return answer.stream().mapToInt(x->x).toArray();
    }
}