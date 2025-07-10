import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] ingredients;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ingredients = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ingredients[i] = new int[]{s, b};
        }
        dfs(0, 1, 0, false);

        System.out.println(minDiff);
    }

    private static void dfs(int idx, int sour, int bitter, boolean used) {
        if (idx == n) {
            if (used) {
                minDiff = Math.min(minDiff, Math.abs(sour - bitter));
            }
            return;
        }
        dfs(idx + 1, sour * ingredients[idx][0], bitter + ingredients[idx][1], true);
        dfs(idx + 1, sour, bitter, used);
    }
}
