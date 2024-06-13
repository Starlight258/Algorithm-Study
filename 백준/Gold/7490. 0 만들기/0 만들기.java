import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    static void dfs(int depth, int sum, int op, String s, int num) {
        if (depth == n) {
            sum += num * op;
            if (sum == 0) {
                System.out.println(s);
            }
            return;
        }
        dfs(depth + 1, sum, op, s + " " + (depth + 1), num * 10 + depth + 1);
        dfs(depth + 1, sum + num * op, 1, s + "+" + (depth + 1), depth + 1);
        dfs(depth + 1, sum + num * op, -1, s + "-" + (depth + 1), depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            dfs(1, 0, 1, "1", 1);
            System.out.println();
        }
    }
}
