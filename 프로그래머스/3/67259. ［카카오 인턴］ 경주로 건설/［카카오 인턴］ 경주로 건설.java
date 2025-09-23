import java.util.*;

class Solution {
    static final int INF = 1_000_000_000;
    static final int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static final int[] dc = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int r, c, dir, cost;
        Node(int r, int c, int dir, int cost) {
            this.r = r; this.c = c; this.dir = dir; this.cost = cost;
        }
        public int compareTo(Node o) { return this.cost - o.cost; }
    }

    public int solution(int[][] board) {
        int n = board.length;
        // cost[r][c][dir] : dir 방향으로 (r,c)에 도착한 최소 비용
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(cost[i][j], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작은 방향 미정: 두 방향(우/하)만 시도해도 되지만, 일반화하려면 dir=-1로 시작
        pq.offer(new Node(0, 0, -1, 0));

        int answer = INF;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 목표 도달 체크: 어떤 방향으로든 최소 갱신
            if (cur.r == n - 1 && cur.c == n - 1) {
                answer = Math.min(answer, cur.cost);
                continue; // 더 작은 비용이 PQ에 남아있을 수 있어 계속
            }

            for (int ndir = 0; ndir < 4; ndir++) {
                int nr = cur.r + dr[ndir];
                int nc = cur.c + dc[ndir];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (board[nr][nc] == 1) continue; // 벽

                int add;
                if (cur.dir == -1) add = 100; // 첫 이동
                else add = (cur.dir == ndir) ? 100 : 600;

                int ncost = cur.cost + add;

                // 현재 방향 기준으로만 비용 테이블 비교
                if (cost[nr][nc][ndir] > ncost) {
                    cost[nr][nc][ndir] = ncost;
                    pq.offer(new Node(nr, nc, ndir, ncost));
                }
            }
        }

        // 혹시 PQ 루프에서 갱신 못한 경우 대비해 최소값 한번 더 계산
        for (int d = 0; d < 4; d++) answer = Math.min(answer, cost[n-1][n-1][d]);
        return answer;
    }
}