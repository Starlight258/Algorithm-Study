import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        for (String[] t:tickets){
            g.computeIfAbsent(t[0], k->new PriorityQueue<>()).offer(t[1]);
        }
        Deque<String> st = new ArrayDeque<>();
        List<String> route = new ArrayList<>();
        st.push("ICN");
        
        while(!st.isEmpty()){
            String cur = st.peek();
            PriorityQueue<String> pq = g.get(cur);
            if (pq != null && !pq.isEmpty()){
                st.push(pq.poll());
            } else {
                route.add(st.pop());
            }
        }
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}