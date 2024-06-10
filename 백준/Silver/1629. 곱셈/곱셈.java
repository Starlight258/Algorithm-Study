import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long pow(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        long temp = pow(a, b / 2, c);
        if (b % 2 == 1) {
            return (temp * temp) % c * a % c;
        }
        return temp * temp % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        System.out.println(pow(a, b, c));
    }
}
