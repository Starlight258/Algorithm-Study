import java.util.*;

class Solution {
    
    public String[] solution(String[][] tickets) {
        
        List<String> answer = new ArrayList<>();
        Map<String, PriorityQueue<String>> q = new HashMap<>();
        
        for (String[] ticket:tickets){
            q.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
                .offer(ticket[1]);        
        }
        
        Stack<String> stk = new Stack<>();
        stk.push("ICN");
        
        while (!stk.isEmpty()){     
            String cur = stk.peek();
            
            if (q.containsKey(cur) && !q.get(cur).isEmpty()) {
                 stk.push(q.get(cur).poll());   
            } else {
                answer.add(stk.pop());
            }
        }
        
        Collections.reverse(answer);
        
        return answer.toArray(new String[0]);
    }
}