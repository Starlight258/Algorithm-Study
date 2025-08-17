import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[][] map;
    private static Map<Integer, Integer> counts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkPaper(0, 0, n);

        System.out.println(counts.getOrDefault(-1, 0));
        System.out.println(counts.getOrDefault(0, 0));
        System.out.println(counts.getOrDefault(1, 0));
    }

    private static void checkPaper(final int y, final int x, final int size) {
        int value = map[y][x];
        if (isMonos(y, x, size)) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
            return;
        }

        int oneThird = size / 3;
        checkPaper(y, x, oneThird);
        checkPaper(y, x + oneThird, oneThird);
        checkPaper(y, x + oneThird * 2, oneThird);

        checkPaper(y + oneThird, x, oneThird);
        checkPaper(y + oneThird, x + oneThird, oneThird);
        checkPaper(y + oneThird, x + oneThird * 2, oneThird);

        checkPaper(y + oneThird * 2, x, oneThird);
        checkPaper(y + oneThird * 2, x + oneThird, oneThird);
        checkPaper(y + oneThird * 2, x + oneThird * 2, oneThird);
    }

    private static boolean isMonos(final int y, final int x, final int size) {
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
