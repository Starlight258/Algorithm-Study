import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            max = Math.max(max, end);

            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        int sum = 0;
        for (int i = 1; i <= max; i++) {
            switch (arr[i]) {
                case 1:
                    sum += a;
                    break;
                case 2:
                    sum += b * 2;
                    break;
                case 3:
                    sum += c * 3;
                    break;
            }
        }

        System.out.println(sum);
    }
}
