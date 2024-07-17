import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int gcd(int n, int m) {
        int r;
        while (m != 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minCommonDivisor = gcd(n, m);
        int maxCommonDenominator = n * m / minCommonDivisor;
        System.out.println(minCommonDivisor);
        System.out.println(maxCommonDenominator);
    }
}
