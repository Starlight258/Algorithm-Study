import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
    이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
     */
    /*
    10 15
    5 1 3 5 10 7 4 9 2 8

    0 5 6 9 14
    i~j : prefix[j] - prefix[i-1]
    투포인터
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()); // 합
        int[] prefix = new int[n + 1];
        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i-1] + nums[i - 1];
        }
        int left = 1;
        int right = 1;
        int length = Integer.MAX_VALUE;
        while (left <= right && right <= n) {
            int diff = prefix[right] - prefix[left - 1];
            if (diff >= s) {
                length = Math.min(right - left + 1, length);
                left++;
            } else {
                right++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(length);
        }
    }

}
