import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 M개를 고른 수열
    같은 수를 여러 번 골라도 된다.
    고른 수열은 비내림차순이어야 한다.
    길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     */
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        backtracking(new ArrayList<>(), 1, n, m);
        System.out.println(sb);
    }

    private static void backtracking(final List<Integer> nums, final int cur, final int n, final int m) {
        if (nums.size() == m) {
            for (Integer i : nums) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = cur; i <= n; i++) {
            nums.add(i);
            backtracking(nums, i, n, m);
            nums.remove(nums.size() - 1);
        }
    }

}
