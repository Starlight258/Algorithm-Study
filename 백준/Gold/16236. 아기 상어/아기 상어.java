import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int sy = 0, sx = 0;
        int[] cur = new int[2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur[0] = i;
                    cur[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        // 2. bfs 수행
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            boolean[][] visited = new boolean[n][n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
                            : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0])
                                    : Integer.compare(o1[1], o2[1]))
            );

            pq.offer(new int[]{cur[0], cur[1], 0});
            visited[cur[0]][cur[1]] = true;
            boolean ck = false;

            while (!pq.isEmpty()) {
                cur = pq.poll();
                int y = cur[0];
                int x = cur[1];
                int dist = cur[2];

                if (map[y][x] != 0 && map[y][x] < size) {
                    map[y][x] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                        continue;
                    }
                    if (!visited[ny][nx] && map[ny][nx] <= size) {
                        pq.offer(new int[]{ny, nx, dist + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
            if (!ck) break;
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}
