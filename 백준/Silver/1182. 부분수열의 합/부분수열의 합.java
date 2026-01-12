import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
     */
    private static int n;
    private static int s;
    private static int answer = 0;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(new ArrayList<>(), 0);
        System.out.println(answer);
    }

    private static void backtracking(List<Integer> cur, int curIndex) {
        if (cur.size() == n + 1) {
            return;
        }
        int sum = 0;
        for (Integer i : cur) {
            sum += i;
        }
        if (!cur.isEmpty() && sum == s) {
            answer++;
        }
        for (int i = curIndex; i < n; i++) {
            cur.add(nums[i]);
            backtracking(cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
