import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static final int dy[] = {-1, 0, 1, 0};
    private static final int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] start = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start = new int[]{i, j, 0};
                    map[i][j] = 0;
                }
            }
        }
        // simulation
        System.out.println(simulation(start));
    }

    private static int simulation(int[] start) {
        int sharkSize = 2;
        int numberOfFishEaten = 0;
        int time = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> { // y, x, 시간
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            pq.offer(start);
            visited[start[0]][start[1]] = true;
            boolean isChecked = false;
            while (!pq.isEmpty()) {
                start = pq.poll();
                int y = start[0];
                int x = start[1];
                int distance = start[2];
                if (map[y][x] != 0 && map[y][x] < sharkSize) {
                    numberOfFishEaten++;
                    time += distance;
                    isChecked = true;
                    map[y][x] = 0;
                    start = new int[]{y, x, 0};
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) {
                        continue;
                    }
                    if (map[ny][nx] <= sharkSize) {
                        pq.offer(new int[]{ny, nx, distance + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
            if (numberOfFishEaten == sharkSize) {
                sharkSize++;
                numberOfFishEaten = 0;
            }
            if (!isChecked) {
                break;
            }
        }
        return time;
    }
}
