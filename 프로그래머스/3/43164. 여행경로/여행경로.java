import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 1) 그래프: 출발지 -> (사전순) 도착지들
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }

        // 2) 스택으로 경로 구성 (ICN에서 시작)
        Deque<String> stack = new ArrayDeque<>();
        List<String> route = new ArrayList<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            PriorityQueue<String> pq = graph.get(cur);
            if (pq != null && !pq.isEmpty()) {
                // 사전순으로 가장 앞의 티켓 하나 소진하며 진행
                stack.push(pq.poll());
            } else {
                // 더 갈 곳이 없으면 현재 노드를 경로에 추가하고 되돌아감
                route.add(stack.pop());
            }
        }

        // 3) 역순으로 쌓였으므로 뒤집기 (길이 = tickets.length + 1)
        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}