import java.util.*;

class Solution {
    private List<String> route;                    // 정답 경로
    private boolean[] used;                        // 티켓 사용 여부
    private Map<String, List<Integer>> adj;        // 공항 -> 티켓 인덱스 목록(도착지 사전순)
    private String[][] tickets;
    private int E;                                 // 간선(티켓) 수

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.E = tickets.length;
        this.used = new boolean[E];
        this.route = new ArrayList<>();
        this.adj = new HashMap<>();

        // 1) 그래프 구성: 출발지 -> (티켓 인덱스 리스트)
        for (int i = 0; i < E; i++) {
            String from = tickets[i][0];
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(i);
        }

        // 2) 각 출발지의 후보 티켓을 "도착지" 기준 사전순 정렬
        for (List<Integer> list : adj.values()) {
            list.sort((a, b) -> tickets[a][1].compareTo(tickets[b][1]));
        }

        // 3) 경로 시작
        route.add("ICN");
        dfs("ICN", 0);  // depth = 사용한 티켓 수

        return route.toArray(new String[0]);
    }

    // 현재 공항 cur, 이미 사용한 티켓 수 depth
    private boolean dfs(String cur, int depth) {
        if (depth == E) {              // 티켓을 전부 사용했다면 경로 완성
            return true;
        }

        List<Integer> list = adj.getOrDefault(cur, Collections.emptyList());
        for (int idx : list) {
            if (used[idx]) continue;

            used[idx] = true;
            String next = tickets[idx][1];
            route.add(next);

            if (dfs(next, depth + 1))  // 사전순으로 도는 중 "첫 완성 경로"가 곧 정답
                return true;

            // 백트래킹
            route.remove(route.size() - 1);
            used[idx] = false;
        }
        return false; // 여기서 못 채우면 상위로 백트래킹
    }
}