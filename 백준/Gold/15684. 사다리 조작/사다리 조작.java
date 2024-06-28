import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H;
    static int[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
        }

        for (int i = 0; i <= 3; i++) { // 3개까지 추가 가능
            dfs(1, 0, i);
        }

        System.out.println(-1);
    }

    // 조합 수행
    static void dfs(int startR, int cnt, int size) {
        if (cnt == size) {
            if (check()) {
                System.out.println(size);
                System.exit(0);
            }
            return;
        }

        for (int r = startR; r <= H; r++) { // 현재 가로선의 위치 (행)
            for (int c = 1; c < N; c++) { // 열
                if (ladder[r][c] == 1) {
                    continue;
                }
                if (ladder[r][c - 1] == 1) { // 왼쪽 확인
                    continue;
                }
                if (ladder[r][c + 1] == 1) { // 오른쪽 확인
                    continue;
                }
                ladder[r][c] = 1;
                dfs(startR, cnt + 1, size);
                ladder[r][c] = 0;
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int curC = i;
            int curR = 1;
            while (curR <= H) {
                if (ladder[curR][curC] == 1) {
                    curC++;
                    curR++;
                } else if (ladder[curR][curC - 1] == 1) {
                    curC--;
                    curR++;
                } else {
                    curR++;
                }
            }
            // i번째 세로선이 i번째로 내려가는지 확인
            if (curC != i) {
                return false;
            }
        }
        return true;
    }
}
