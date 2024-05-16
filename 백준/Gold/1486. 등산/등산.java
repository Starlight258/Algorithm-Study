import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M, T, D;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[][] cost;
    static ArrayList<Node>[][] list;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());
        D = stoi(st.nextToken());

        init();

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = ctoi(input[j]);
            }
        }

        XYcompression();

        dijkstra(list[0], cost[0]);
        dijkstra(list[1], cost[1]);

        int max = map[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cost[0][i * M + j] + cost[1][i * M + j] <= D) {
                    max = Math.max(max, map[i][j]);
                }
            }
        }
        System.out.println(max);
    }

    private static void init() {
        map = new int[N][M];
        cost = new int[2][N * M];
        list = new ArrayList[2][N * M];
        for (int i = 0; i < N * M; i++) {
            for (int j = 0; j < 2; j++) {
                list[j][i] = new ArrayList<>();
                cost[j][i] = 98765432;
            }
        }
    }

    private static void XYcompression() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        int here = map[x][y], there = map[nx][ny], gap = Math.abs(here - there);
                        if (gap <= T) {
                            if (here >= there) {
                                list[0][x * M + y].add(new Node(nx * M + ny, 1));
                            } else {
                                list[0][x * M + y].add(new Node(nx * M + ny, gap * gap));
                            }

                            if (here > there) {
                                list[1][x * M + y].add(new Node(nx * M + ny, gap * gap));
                            } else {
                                list[1][x * M + y].add(new Node(nx * M + ny, 1));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void dijkstra(ArrayList<Node>[] list, int[] cost) {
        pq.add(new Node(0, 0));
        cost[0] = 0;

        while (!pq.isEmpty()) {
            Node here = pq.poll();
            if (cost[here.idx] < here.cost) {
                continue;
            }

            for (Node there : list[here.idx]) {
                if (cost[there.idx] > here.cost + there.cost) {
                    cost[there.idx] = here.cost + there.cost;
                    pq.add(new Node(there.idx, cost[there.idx]));
                }
            }
        }
    }

    private static int ctoi(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else {
            return c - 'a' + 26;
        }
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}

