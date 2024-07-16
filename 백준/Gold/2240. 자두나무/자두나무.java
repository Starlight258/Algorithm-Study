import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int w;
    static int[] arr;
    static int[][][] dp; // 시간 위치 이동횟수
    static int answer = 0;

    static int go(int curW, int curT, int pos) {
        if (curT == t) {
            return 0;
        }
        if (dp[curT][pos][curW] != 0) {
            return dp[curT][pos][curW];
        }
        int movePos = pos == 1 ? 0 : 1;
        int move = 0;
        if (curW < w) {
            move = go(curW + 1, curT + 1, movePos) + (movePos == arr[curT] ? 1 : 0);
        }
        int notMove = go(curW, curT + 1, pos) + (arr[curT] == pos ? 1 : 0);
        return dp[curT][pos][curW] = Math.max(move, notMove);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }
        dp = new int[t + 1][2][w + 1];
        answer = Math.max(go(0, 0, 0), go(1, 0, 1));
        System.out.println(answer);
    }
}
