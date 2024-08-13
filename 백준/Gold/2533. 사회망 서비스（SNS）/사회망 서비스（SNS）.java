import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer>[] tree;
    static int[][] dp;

    private static void dfs(int node, int parent) {
        dp[node][0] = 0; // 얼리어답터 아닐때 서브트리에 필요한 최소 얼리어답터 수(자신 포함)
        dp[node][1] = 1; // 얼리어답터 일때 서브트리에 필요한 최소 얼리어답터 수(자신 포함)

        for (Integer child : tree[node]) {
            if (child != parent) {
                dfs(child, node); // 리프노드까지
                dp[node][0] += dp[child][1]; // 모든 자식은 얼리어답터여야함
                dp[node][1] += Math.min(dp[child][0], dp[child][1]); // 자식은 얼리어답터일수도 있고, 아닐수도있음
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        dp = new int[n + 1][2]; // 해당 노드, 얼리어답터 여부(0:아님, 1:맞음) - 서브트리에 필요한 최소 얼리어답터 수

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
