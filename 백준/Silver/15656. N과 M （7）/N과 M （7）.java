import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
    N개의 자연수 중에서 M개를 고른 수열
     */
    private static final StringBuilder sb = new StringBuilder();

    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        Arrays.sort(nums);

        backtracking(new ArrayList<>(), n, m);
        System.out.println(sb);
    }

    private static void backtracking(final List<Integer> answer, final int n, final int m) {
        if (answer.size() == m) {
            for (Integer i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            answer.add(cur);
            backtracking(answer, n, m);
            answer.remove(answer.size() - 1);
        }
    }

}
