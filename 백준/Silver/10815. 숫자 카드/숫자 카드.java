import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
    정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
     */
    /*
    정수에 대해 이분탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        int[] picks = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            picks[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int pick : picks) {
            if (binarySearch(pick, n, nums)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(final int pick, final int n, final int[] nums) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == pick) {
                return true;
            } else if (nums[mid] < pick) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
