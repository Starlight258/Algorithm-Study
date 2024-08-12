import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[][][][][] visited; // a 남은횟수,b 남은횟수,c 남은횟수, 1번째전 알파벳, 2번째전 알파벳
    static int aCnt = 0, bCnt = 0, cCnt = 0;

    private static void dfs(int a, int b, int c, String record, int prev, int secondPrev) {
        if (a == 0 && b == 0 && c == 0) {
            System.out.println(record);
            System.exit(0);
        }

        if (visited[a][b][c][prev][secondPrev]) {
            return;
        }

        visited[a][b][c][prev][secondPrev] = true;

        if (a > 0) {
            dfs(a - 1, b, c, record + 'A', 0, prev);
        }
        if (b > 0 && prev != 1) {
            dfs(a, b - 1, c, record + 'B', 1, prev);
        }
        if (c > 0 && secondPrev != 2 && prev != 2) {
            dfs(a, b, c - 1, record + 'C', 2, prev);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'A') {
                aCnt++;
            } else if (line.charAt(i) == 'B') {
                bCnt++;
            } else {
                cCnt++;
            }
        }
        visited = new boolean[aCnt + 1][bCnt + 1][cCnt + 1][3][3]; // 0:A, 1:B, 2:C

        dfs(aCnt, bCnt, cCnt, "", 0, 0);

        System.out.println(-1);
    }
}
