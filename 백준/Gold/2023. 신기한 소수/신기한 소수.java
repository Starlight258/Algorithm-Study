import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        getResult(0, n);
        System.out.println(sb);
    }

    private static void getResult(int output, int digitNum) { // 결과값, 자리수
        if (digitNum == 0) {
            sb.append(output).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            int next = output * 10 + i;
            if (isPrime(next)) {
                getResult(next, digitNum - 1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
