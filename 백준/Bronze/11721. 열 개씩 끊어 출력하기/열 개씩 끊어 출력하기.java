import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (i != 0 && i % 10 == 0) {
                sb.append("\n");
            }
            sb.append(input[i]);
        }
        System.out.println(sb);
    }
}
