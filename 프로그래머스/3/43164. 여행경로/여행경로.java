import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket:tickets){
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).offer(ticket[1]);
        }
        
        Stack<String> stk = new Stack<>();
        stk.push("ICN");
        while (!stk.isEmpty()){
            String cur = stk.peek();
            PriorityQueue<String> queue = map.get(cur);
            if (queue != null && !queue.isEmpty()){
                stk.push(queue.poll());
            } else {
                answer.add(stk.pop());
            }
        }
        
        Collections.reverse(answer);
        return answer.toArray(String[]::new);
    }
    // 큐로 진행, 우선순위 큐 : Map<String, PriorityQueue<String>> map
    // 큐에 없을 때까지 진행
    // 모든 항공권을 사용해야하므로 Stack 먼저 집어넣기 Stack<String>
}