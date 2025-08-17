import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int answer = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] red;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        red = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start(0, 0);
        System.out.println(answer);
    }

    private static void start(final int depth, final int count) {
        if (count == n / 2) {
            answer = Math.min(answer, calculateDiff());
            return;
        }
        if (depth == n) {
            return;
        }

        red[depth] = true;
        start(depth + 1, count + 1);
        red[depth] = false;
        start(depth + 1, count);
    }

    private static int calculateDiff() {
        int redScore = 0;
        int blueScore = 0;
        for (int i = 0; i < n; i++) {
            boolean isRed = red[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isRed == red[j]) {
                    if (isRed) {
                        redScore += map[i][j];
                    } else {
                        blueScore += map[i][j];
                    }
                }
            }
        }
        return Math.abs(redScore - blueScore);
    }

}
