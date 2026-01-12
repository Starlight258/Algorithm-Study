import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*
    N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    N개의 자연수 중에서 M개를 고른 수열
    고른 수열은 비내림차순이어야 한다.
    길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     */
    /*

     */
    private static int n;
    private static int m;
    private static int[] nums;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        backtracking(new ArrayList<>(), 0);
        System.out.println(sb);
    }

    private static void backtracking(List<Integer> cur, int curIndex) {
        if (cur.size() == m) {
            for (Integer i : cur) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int last = 0;
        for (int i = curIndex; i < n; i++) {
            int num = nums[i];
            if (last == num) {
                continue;
            }
            cur.add(num);
            backtracking(cur, i + 1);
            cur.remove(cur.size() - 1);
            last = num;
        }
    }
}
