import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int num;
        int remainder;
        int count;
        while ((input = br.readLine()) != null) {
            num = Integer.parseInt(input);
            remainder = 1;
            count = 1;
            while (remainder % num != 0) {
                remainder = (remainder * 10 + 1) % num;
                count++;
            }
            System.out.println(count);
        }
    }
}