import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    3 1

    1
    2
    3
     */
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        backtracking(new ArrayList<>(), n, m);
        System.out.println(sb);
    }

    private static void backtracking(final List<Integer> nums, final int n, final int m) {
        if (nums.size() == m) {
            for (Integer i : nums) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            backtracking(nums, n, m);
            nums.remove(nums.size() - 1);
        }
    }

}
