import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 누적합 구하기
        int[] pSum = new int[n];
        pSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + arr[i];
        }

        //3. k일 동안의 최대값 구하기
        int sum = pSum[k - 1];
        for (int i = k; i < pSum.length; i++) {
            sum = Math.max(sum, pSum[i] - pSum[i - k]);
        }
        System.out.println(sum);
    }
}
