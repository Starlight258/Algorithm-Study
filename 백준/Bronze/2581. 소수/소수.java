import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int total = 0;
        int minValue = -1;
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                if (total == 0) {
                    minValue = i;
                }
                total += i;
            }
        }
        if (minValue == -1) {
            System.out.println(-1);
            return;
        }
        System.out.println(total);
        System.out.println(minValue);
    }
}
