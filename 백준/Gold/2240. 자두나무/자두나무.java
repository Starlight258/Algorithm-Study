import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] apple;
    static int[][][] dp = new int[1004][2][34];  // 시간 위치 이동횟수
    public static int dfs(int t, int pos, int w, int time){
        if (t == time) return 0;
        if (dp[t][pos][w]>0) return dp[t][pos][w];
        int notMove = dfs(t+1, pos, w, time) + (apple[t]-1 == pos ? 1 : 0);
        int move = 0;
        if (w>0) move = dfs(t+1, (pos==0?1:0), w-1, time) + + (apple[t]-1 == pos ? 1 : 0);
        return dp[t][pos][w] = Math.max(notMove, move);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int wMove = Integer.parseInt(st.nextToken());
        apple = new int[time];
        for (int i = 0; i < time; i++) {
            apple[i] = Integer.parseInt(br.readLine());
        }
        int answer = Math.max(dfs(0, 0, wMove, time), dfs(0, 1, wMove - 1, time));
        System.out.println(answer);
    }


}
