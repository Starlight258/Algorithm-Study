import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
    이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
     */
    /*
    부분합 : prefix[i], i=1부터 시작
    i~j : prefix[j+1] - prefix[i]
    적절히 i,j 고르기
    4 2
    1 1 1 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int answer = 0;
        long sum = 0;
        while (start <= end) {
            if (sum >= m) {
                if (sum == m) {
                    answer++;
                }
                sum -= nums[start];
                start++;
            } else if (end >= n) {
                break;
            } else {
                sum += nums[end];
                end++;
            }
        }
        System.out.println(answer);
    }
}
