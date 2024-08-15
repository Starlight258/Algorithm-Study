import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 30;

    static int n;
    static int k;
    static char[] str;
    static boolean[][][][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        str = new char[n];
        // dp[idx][a][b][pairNum] : idx 위치까지 a의 개수, b의 개수, pairNum 쌍 개수
        dp = new boolean[MAX + 1][MAX + 1][MAX + 1][(MAX) * (MAX - 1) / 2 + 1];

        if (findStr(0, 0, 0, 0)) {
            System.out.println(new String(str));
        } else {
            System.out.println(-1);
        }
    }

    private static boolean findStr(int idx, int a, int b, int pairNum) {
        if (idx == n) {
            return pairNum == k;
        }

        if (dp[idx][a][b][pairNum]) {
            return false;
        }
        dp[idx][a][b][pairNum] = true;

        str[idx] = 'A';
        if (findStr(idx + 1, a + 1, b, pairNum)) {
            return true;
        }

        str[idx] = 'B';
        if (findStr(idx + 1, a, b + 1, pairNum + a)) {
            return true;
        }

        str[idx] = 'C';
        if (findStr(idx + 1, a, b, pairNum + a + b)) {
            return true;
        }
        return false;
    }
}
