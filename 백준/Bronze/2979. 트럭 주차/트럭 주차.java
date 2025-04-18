import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        final int c = Integer.parseInt(st.nextToken());
        int[] time = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int index = start; index < end; index++) {
                time[index]++;
            }
        }

        int answer = 0;
        for (int t : time) {
            switch (t) {
                case 1:
                    answer += a;
                    break;
                case 2:
                    answer += b * 2;
                    break;
                case 3:
                    answer += c * 3;
                    break;

            }
        }
        System.out.println(answer);
    }
}
