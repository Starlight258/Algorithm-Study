import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //2. 빗물 구하기
        int answer = 0;
        for (int i = 1; i < w; i++) {
            // left max
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            // right max
            int rightMax = 0;
            for (int j = i + 1; j < w; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            int pole = Math.min(leftMax, rightMax);
            if (pole > arr[i]) {
                answer += pole - arr[i];
            }
        }

        System.out.println(answer);
    }
}
