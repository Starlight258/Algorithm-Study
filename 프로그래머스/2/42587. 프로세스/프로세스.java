import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)-> p2-p1);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0;i<priorities.length;i++){
            queue.offer(i);
            pq.offer(priorities[i]);
            mp.put(i, priorities[i]);
        }
        
        while (!queue.isEmpty()){
            int prio = pq.peek();
            int e = queue.poll();
            if (mp.get(e) != prio){
                queue.offer(e);
            } else {
                answer++;
                if (e == location){
                    return answer;
                }
                pq.poll();
            }
        }
        return answer;
    }
    
    // 대기큐, 우선순위큐 
    // 문제 : 같은 대기 우선순위가 있다면? -> 
    // 현재 가장 높은 우선순위만 저장, 우선순위가 바뀐다면 그 다음걸로 저장, 선택시에 pop
    // 자료구조: 큐, 우선순위큐, Map<인덱스, 우선순위>
    // 순서
    // 1. 우선순위 큐에 있는 우선순위의 원소 꺼내기 (아닐 경우 다시 집어넣기)
    // 2. 꺼낸 프로세스가 대상 프로세스라면 종료 
    // 3. 그 다음 우선순위 찾기 
}