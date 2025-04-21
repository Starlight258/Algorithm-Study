import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int number = 0; number <= 40; number++) {
            fibonacci(number, dp);
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] fibonacci = fibonacci(n, dp);
            System.out.println(fibonacci[0] + " " + fibonacci[1]);
        }

    }

    private static int[] fibonacci(final int number, final int[][] dp) {
        if ((dp[number][0] != 0 || dp[number][1] != 0)) {
            return dp[number];
        }
        int[] first = fibonacci(number - 1, dp);
        int[] second = fibonacci(number - 2, dp);
        dp[number][0] = first[0] + second[0];
        dp[number][1] = first[1] + second[1];
        return dp[number];
    }
}
