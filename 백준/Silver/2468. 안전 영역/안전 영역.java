import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static void dfs(int y, int x, int height, int[][] map, boolean[][] visited) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) {
                continue;
            }
            if (!visited[ny][nx] && map[ny][nx] > height) {
                dfs(ny, nx, height, map, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int maxHeight = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        // 2. 길이 1~maxHeight까지 안전영역 구하기
        int answer = 0;
        for (int i = 0; i <= maxHeight; i++) {
            int cnt = 0;
            boolean[][] visited = new boolean[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        cnt++;
                        dfs(j, k, i, map, visited);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        //3. 정답 출력
        System.out.println(answer);
    }
}
