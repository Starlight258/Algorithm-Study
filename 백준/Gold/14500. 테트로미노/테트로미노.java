import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static int n;
    static int m;
    static int[][] map;

    static void doTetromino(int y, int x) {
        //1. ㅜ (
        if (y + 1 < n && x + 2 < m) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y + 1][x + 1];
            answer = Math.max(answer, sum);
        }
        //2. ㅗ
        if (y - 1 >= 0 && x + 2 < m) {
            int sum = map[y][x] + map[y][x + 1] + map[y][x + 2] + map[y - 1][x + 1];
            answer = Math.max(answer, sum);
        }

        //3. ㅓ
        if (y > 0 && x + 1 < m && y + 1 < n) {
            int sum = map[y][x] + map[y][x + 1] + map[y + 1][x + 1] + map[y - 1][x + 1];
            answer = Math.max(answer, sum);
        }

        //4. ㅏ
        if (y + 2 < n && x + 1 < m) {
            int sum = map[y][x] + map[y + 1][x] + map[y + 2][x] + map[y + 1][x + 1];
            answer = Math.max(answer, sum);
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean[][] visited;

    static void doDfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            doDfs(ny, nx, depth + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 테트로미노 놓기
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                doTetromino(i, j);
                doDfs(i, j, 0, 0);
            }
        }

        //3. 결과 출력하기
        System.out.println(answer);
    }
}
