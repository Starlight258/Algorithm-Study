import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
    N개의 자연수 중에서 M개를 고른 수열
     */
    private static final StringBuilder sb = new StringBuilder();

    private static int[] nums;
    private static boolean[] visited;
    private static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        visited = new boolean[n];
        answer = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        Arrays.sort(nums);

        backtracking(new ArrayList<>(), n, m);
        System.out.println(sb);
    }

    private static void backtracking(final List<Integer> tmp, final int n, final int m) {
        if (tmp.size() == m) {
            for (Integer t : tmp) {
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        }
        int last = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int cur = nums[i];
            if (last == cur) { // 같은 depth에서는 중복되지 않게
                continue;
            }
            visited[i] = true;
            tmp.add(cur);
            backtracking(tmp, n, m);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
            last = cur;
        }
    }
}
