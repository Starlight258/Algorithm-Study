import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final int MAX = 1000000;

    static int n;
    static String line;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        line = br.readLine();

        //2. 에너지
        dp = new int[n];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'B') {
                makeDp(i, 'O');
            } else if (c == 'O') {
                makeDp(i, 'J');
            } else {
                makeDp(i, 'B');
            }
        }

        if (dp[line.length() - 1] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[line.length() - 1]);
        }
    }

    private static void makeDp(int index, char c) {
        for (int i = index + 1; i < line.length(); i++) {
            if (line.charAt(i) == c) {
                dp[i] = Math.min(dp[i], dp[index] + (int) Math.pow(i - index, 2));
            }
        }
    }
}
