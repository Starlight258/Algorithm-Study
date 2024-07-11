import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 2. 투포인터
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int minTotal = Integer.MAX_VALUE;
        int[] values = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) <= minTotal) {
                minTotal = Math.abs(sum);
                values = new int[]{left, right};
                if (sum == 0) {
                    break;
                }
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }
        System.out.println(arr[values[0]] + " " + arr[values[1]]);
    }
}
