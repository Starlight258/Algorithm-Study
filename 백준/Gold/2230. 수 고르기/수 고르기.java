import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
    N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다.
    이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

    예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다.
    이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.
     */
    /*
    3 3
    1
    5
    3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 차이
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        while (left <= right && right < n) {
            int diff = nums[right] - nums[left];
            if (diff >= m) {
                answer = Math.min(answer, diff);
                left++;
            } else {
                right++;
            }
        }
        System.out.println(answer);
    }

}
