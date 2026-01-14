import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
     */
    /*
    a^b%mod = 2^5%mod3 = (2^3%mod3 * 2^2%mod3) mod3 = (2 * 1) mod 3 = 2;
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long answer = pow(a, b, c);
        System.out.println(answer);
    }

    private static long pow(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long value = pow(a, b / 2, c);
        value = value * value % c;
        if (b % 2 == 0) {
            return value;
        }
        return value * a % c;
    }

}
