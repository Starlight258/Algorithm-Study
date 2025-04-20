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
        int l = Integer.parseInt(st.nextToken());
        int[] counts = new int[n];
        int index = 0;
        int answer = 0;
        while (true) {
            counts[index] += 1;
            if (counts[index] == m) {
                break;
            }
            if (counts[index] % 2 == 0) {
                index = (index - l + n) % n;
            } else {
                index = (index + l) % n;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
