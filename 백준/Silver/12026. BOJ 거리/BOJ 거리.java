import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static String line;
    static int[] dp;
    static int MAX = 1000000;

    private static void updateDp(final int idx, final char c) {
        for (int i = idx + 1; i < line.length(); i++) {
            if (line.charAt(i) == c) {
                dp[i] = Math.min(dp[i], dp[idx] + (int) Math.pow((i - idx), 2));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = br.readLine();

        dp = new int[n];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'B') {
                updateDp(i, 'O');
            } else if (c == 'O') {
                updateDp(i, 'J');
            } else {
                updateDp(i, 'B');
            }
        }

        System.out.println(dp[n - 1] == MAX ? -1 : dp[n - 1]);
    }
}
