import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.
    어느 날 이 N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.
    각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.
    이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.
     */

    /*
    N개의 마을, M개의 도로, 도착지 X
    X 마을까지 오고 가는데 가장 많은 시간을 소비하는 학생
    4 8 2
    1 2 4
    1 3 2
    1 4 7
    2 1 1
    2 3 5
    3 1 2
    3 4 4
    4 2 3

    1번 학생 : 1->2->1 : 4 + 1 = 5
    2번 학생 : 2 : 0
    3번 학생 : 3->4->2->1->3 : 10 vs 3->1->2->1->3 : 9 : 9
    4번 학생 : 4->2->1->4: 3+1+7=11
    7 vs 3->1->2 : 6 : 7
    4->2->3- : 3+1+5
    d[i][j] : i에서 출발, j에서 도착할때의 최소 거리
    플로이드 워셜 : d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]) -> N>=1000이면 시간초과
    다익스트라 : st -> x -> st
     */
    public static List<List<Node>> edges = new ArrayList<>();
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(s).add(new Node(e, cost));
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i, x) + dijkstra(x, i));
        }
        System.out.println(answer);
    }

    private static int dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.edge;
            if (dist[cur] < node.value) {
                continue;
            }
            for (Node next : edges.get(cur)) {
                int nextEdge = next.edge;
                int nextValue = next.value;
                int cost = dist[cur] + nextValue;
                if (cost < dist[nextEdge]) {
                    dist[nextEdge] = cost;
                    queue.offer(new Node(nextEdge, cost));
                }
                if (nextEdge == end) {
                    break;
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int edge;
        int value;

        public Node(final int edge, final int value) {
            this.edge = edge;
            this.value = value;
        }

        @Override
        public int compareTo(final Node o) {
            return this.value - o.value;
        }
    }
}
