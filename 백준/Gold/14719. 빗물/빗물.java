import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < w; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            for (int j = i; j < w; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            answer += Math.min(leftMax, rightMax) - arr[i];
        }
        System.out.println(answer);
    }
}
