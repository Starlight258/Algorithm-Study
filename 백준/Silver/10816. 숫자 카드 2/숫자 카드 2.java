import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    숫자 카드는 정수 하나가 적혀져 있는 카드이다.
    상근이는 숫자 카드 N개를 가지고 있다.
    정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
    10
    6 3 2 10 10 10 -10 -10 7 3
    8
    10 9 -5 2 3 4 5 -10
     */
    /*
    -10 -10 2 3 3 6 7 10 10 10
     */
    private static int n;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(nums);
        int m = Integer.parseInt(br.readLine());
        int[] picks = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            picks[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            int pick = picks[i];
            int lower = lowerBound(pick);
            int upper = upperBound(pick);
            sb.append(upper - lower).append(" ");
        }
        System.out.println(sb);
    }

    // 처음으로 해당 값이 존재하는 인덱스
    private static int lowerBound(int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            // 2 2 3 3 4 5 6
            if (nums[mid] < target) { // 값이 작으면 update
                left = mid + 1;
            } else {
                right = mid; // 값이 크거나 같으면 pass
            }
        }
        return left;
    }

    // 처음으로 해당 값이 오르는 인덱스
    private static int upperBound(int target) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            // 2 2 3 3 4 5 6
            if (nums[mid] <= target) { // 값이 작거나 같으면
                left = mid + 1;
            } else { // 값이 크면
                right = mid;
            }
        }
        return left;
    }
}
