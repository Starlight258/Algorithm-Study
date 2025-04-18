import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int left = 1;
        int right = m;
        int answer = 0;
        while (j-- > 0) {
            int apple = Integer.parseInt(br.readLine());
            while (true) {
                if (canGetApple(left, apple, right)) {
                    break;
                }
                answer++;
                if (apple < left) {
                    left--;
                    right--;
                    continue;
                }
                left++;
                right++;
            }
        }
        System.out.println(answer);
    }

    private static boolean canGetApple(final int left, final int apple, final int right) {
        return left <= apple && apple <= right;
    }
}
