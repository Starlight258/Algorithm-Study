import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        // priorityQueue에는 무적권을 사용하여 처리한 적의 수를 저장
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0; i<enemy.length;i++){

            if(k>0){
                // 무적권이 남아있다면 일단 사용
                que.add(enemy[i]);
                k--;
            }else{
                //무적권을 다 쓴 경우 
                int num = enemy[i];
                // 무적권을 사용하여 처리한 적의 수 중 가장 적은 수와
                // 현재 만난 적의 수를 비교하여 
                // 현재 적이 더 많다면
                if(que.peek() < enemy[i]){

                //현재 적에게 무적권을 쓰고 이전의 적은 그냥 처리
                    num = que.poll();
                    que.add(enemy[i]);
                }

                // 여기서 num은 현재 만난 적과 무적권을 쓴 적 중 가장 적은 수 둘 중 하나
                if(n>=num){
                    // 만약 내 병사의 수가 남아있다면 적의 수만큼 차감하고 이어서 진행
                    n-=num;
                }else break; // 병사가 없다면 종료

            }
            answer++;
        }

        return answer;
    }
}
