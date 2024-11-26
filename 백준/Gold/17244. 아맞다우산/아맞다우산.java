import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final char EXIT = 'E';
    static final char START = 'S';
    static final char MUST_HAVE = 'X';
    static final char WALL = '#';
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static final ArrayList<Node>[] adjacent = new ArrayList[6];

    static int[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer mapInfo = new StringTokenizer(br.readLine());

        int itemNumber = 0;
        int M = Integer.parseInt(mapInfo.nextToken());
        int N = Integer.parseInt(mapInfo.nextToken());

        for (int i = 0; i < 6; i++) {
            adjacent[i] = new ArrayList<>();
        }
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == MUST_HAVE) {
                    map[i][j] = ++itemNumber; // 물건 1~6까지 번호 지정
                }
            }
        }
        initEdge(N, M);
        solution(itemNumber, 0, 0, new boolean[6], 0);
        System.out.println(min);
    }

    static void solution(int totalCount, int depth, int length, boolean[] use, int to) {
        if (depth == totalCount) {
            for (Node edge : adjacent[to]) {
                if (edge.to == 6) { // 출구 더하기
                    min = Math.min(length + edge.weight, min);
                    return;
                }
            }
        }
        for (Node edge : adjacent[to]) { // 인접 위치로 이동(경유지 거치면서 거리 구하기)
            if (edge.to != 6 && !use[edge.to]) {
                use[edge.to] = true;
                solution(totalCount, depth + 1, length + edge.weight, use, edge.to);
                use[edge.to] = false;
            }
        }
    }

    static void initEdge(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == START) { // 시작점에서의 모든 거리
                    bfs(new Point(j, i), N, M, 0);
                } else if (map[i][j] >= 1 && map[i][j] <= 5) { // 경로 위치에서의 모든 거리
                    bfs(new Point(j, i), N, M, map[i][j]);
                }
            }
        }
    }

    static void bfs(Point startPoint, int N, int M, int index) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(startPoint);
        visited[startPoint.y][startPoint.x] = true;
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point temp = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int Y = temp.y + dy[d];
                    int X = temp.x + dx[d];
                    if (visited[Y][X]) {
                        continue;
                    }
                    if (map[Y][X] >= 1 && map[Y][X] <= 5) { // 경유점
                        visited[Y][X] = true;
                        adjacent[index].add(new Node(map[Y][X], length + 1));
                        queue.add(new Point(X, Y));
                    } else if (map[Y][X] == EXIT) { // 나가는 위치
                        visited[Y][X] = true;
                        adjacent[index].add(new Node(6, length + 1));
                    } else if (map[Y][X] != WALL) { // 벽
                        visited[Y][X] = true;
                        queue.add(new Point(X, Y));
                    }
                }
            }
            length++;
        }
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
