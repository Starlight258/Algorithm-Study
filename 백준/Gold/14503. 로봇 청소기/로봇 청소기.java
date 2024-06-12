import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int r;
    static int c;
    static int d;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //2. 현재칸 청소
        clean();
        //3. 정답 출력
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void clean() {
        map[r][c] = 2;

        for (int i = 0; i < 4; i++) {
            rotate();
            int ny = r + dy[d];
            int nx = c + dx[d];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            // 청소되지 않은 빈칸이 있는 경우
            if (map[ny][nx] == 0) {
                r = ny;
                c = nx;
                clean();
                return;
            }
        }
        // 청소되지 않은 빈칸이 없는 경우
        if (moveBack()) {
            clean();
        }
    }


    private static boolean moveBack() {
        int ny = r - dy[d];
        int nx = c - dx[d];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
            return false;
        }
        if (map[ny][nx] != 1) {
            r = ny;
            c = nx;
            return true;
        }
        return false;
    }

    private static void rotate() {
        d = (d + 3) % 4;
    }
}
