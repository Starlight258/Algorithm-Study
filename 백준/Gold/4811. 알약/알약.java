import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[][] dp;

    static long go(int w, int h) {
        if (w == 0 && h == 0) {
            return 1;
        }
        if (dp[w][h] != 0) {
            return dp[w][h];
        }
        if (w > 0) {
            dp[w][h] += go(w - 1, h + 1);
        }
        if (h > 0) {
            dp[w][h] += go(w, h - 1);
        }
        return dp[w][h];
    }

    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            dp = new long[n + 1][n + 1];
            System.out.println(go(n, 0));
            n = Integer.parseInt(br.readLine());
        }
    }
}
