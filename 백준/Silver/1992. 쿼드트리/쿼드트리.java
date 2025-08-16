import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        solve(n, 0, 0);
        System.out.println(answer);
    }

    private static void solve(final int n, final int y, final int x) {
        if (isUniform(n, y, x)) {
            answer.append(map[y][x]);
            return;
        }

        int half = n / 2;
        answer.append("(");
        solve(half, y, x);
        solve(half, y, x + half);
        solve(half, y + half, x);
        solve(half, y + half, x + half);
        answer.append(")");
    }

    private static boolean isUniform(final int size, final int y, final int x) {
        int val = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (val != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
