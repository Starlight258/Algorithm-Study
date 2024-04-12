
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int time;
        int price;
        Pair(int time, int price){
            this.time = time;
            this.price = price;
        }
    }
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> planList = new ArrayList<>();
        StringTokenizer st;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            planList.add(new Pair(a, b));
        }
        dp = new int[n+1]; // 1~n
        for (int i=0;i<n;i++){
            Pair p = planList.get(i);
            if (i+p.time <= n){
                dp[i + p.time] = Math.max(dp[i + p.time], dp[i] + p.price);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        int answer = 0;
        for (int i=1;i<=n;i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(dp[n]);
    }
}
