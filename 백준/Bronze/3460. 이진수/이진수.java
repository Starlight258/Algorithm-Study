import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String binaryN = Integer.toBinaryString(n);
            StringBuilder sb = new StringBuilder();
            int length = binaryN.length();
            for (int j = length - 1; j >= 0; j--) {
                if (binaryN.charAt(j) == '1') {
                    sb.append(length - j - 1).append(" ");
                }
            }
            System.out.println(sb);
        }
    }
}
