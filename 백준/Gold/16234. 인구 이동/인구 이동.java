import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited = new boolean[51][51];
    static int sum = 0;
    static int cnt = 0;

    private static void dfs(int y, int x, List<Integer[]> temp) {
        visited[y][x] = true;
        temp.add(new Integer[]{y, x});

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) {
                continue;
            }
            if (
                    !visited[ny][nx] &&
                            Math.abs(map[y][x] - map[ny][nx]) >= l &&
                            Math.abs(map[y][x] - map[ny][nx]) <= r
            ) {
                dfs(ny, nx, temp);
                cnt++;
                sum += map[ny][nx];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 인구이동 시작
        int answer = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sum = map[i][j];
                    cnt = 1;

                    List<Integer[]> temp = new ArrayList<>();
                    if (!visited[i][j]) {
                        dfs(i, j, temp);
                    }
                    if (cnt > 1) {
                        for (Integer[] integers : temp) {
                            map[integers[0]][integers[1]] = sum / cnt;
                            flag = true;
                        }
                    }
                }
            }

            if (flag) {
                answer++;
            } else {
                break;
            }
        }

        // 3. 정답 출력
        System.out.println(answer);
    }
}
