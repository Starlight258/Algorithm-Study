import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] result = matrixPower(new long[][]{{1, 1}, {1, 0}}, n - 1);
        System.out.println(result[0][0]);
    }

    static long[][] matrixPower(long[][] base, long exponent) {
        long[][] result = {{1, 0}, {0, 1}};

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = multiplyMatrix(result, base);
            }
            exponent /= 2;
            base = multiplyMatrix(base, base);
        }

        return result;
    }

    private static long[][] multiplyMatrix(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return result;
    }
}
