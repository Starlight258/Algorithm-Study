import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static char[][] graph;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<int[]> coins;

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{coins.get(0)[0], coins.get(0)[1], coins.get(1)[0], coins.get(1)[1], 0});
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[coins.get(0)[0]][coins.get(0)[1]][coins.get(1)[0]][coins.get(1)[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y1 = cur[0];
            int x1 = cur[1];
            int y2 = cur[2];
            int x2 = cur[3];
            int count = cur[4];
            if (count >= 10) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                boolean fall1 = false;
                boolean fall2 = false;

                int ny1 = y1 + dy[i];
                int nx1 = x1 + dx[i];
                if (ny1 < 0 || nx1 < 0 || ny1 >= n || nx1 >= m) {
                    fall1 = true;
                } else if (graph[ny1][nx1] == '#') {
                    ny1 = y1;
                    nx1 = x1;
                }
                int ny2 = y2 + dy[i];
                int nx2 = x2 + dx[i];
                if (ny2 < 0 || nx2 < 0 || ny2 >= n || nx2 >= m) {
                    fall2 = true;
                } else if (graph[ny2][nx2] == '#') {
                    ny2 = y2;
                    nx2 = x2;
                }
                if (fall1 && fall2) {
                    continue;
                } else if (!fall1 && !fall2) {
                    if (visited[ny1][nx1][ny2][nx2]) {
                        continue;
                    }
                    q.offer(new int[]{ny1, nx1, ny2, nx2, count + 1});
                    visited[ny1][nx1][ny2][nx2] = true;
                } else {
                    return count + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j);
                if (graph[i][j] == 'o') {
                    coins.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }
}
