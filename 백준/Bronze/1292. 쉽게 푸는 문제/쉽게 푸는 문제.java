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
        int[] arr = new int[b + 1];
        int n = 1;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (n == count) {
                n++;
                count = 0;
            }
            arr[i] = n;
            count++;
        }
        int answer = 0;
        for (int i = a; i <= b; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
