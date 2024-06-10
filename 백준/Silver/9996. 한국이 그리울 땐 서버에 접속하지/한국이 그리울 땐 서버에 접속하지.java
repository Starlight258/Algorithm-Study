
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void check(String pattern, String input, int fIdx) {
        if (pattern.length() > input.length() + 1) {
            System.out.println("NE");
            return;
        }
        for (int i = 0; i < fIdx; i++) {
            if (pattern.charAt(i) != input.charAt(i)) {
                System.out.println("NE");
                return;
            }
        }
        int eLength = pattern.length() - fIdx - 1;
        for (int i = eLength; i > 0; i--) {
            if (pattern.charAt(pattern.length() - i) != input.charAt(input.length() - i)) {
                System.out.println("NE");
                return;
            }
        }
        System.out.println("DA");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        int fIdx = pattern.indexOf('*');
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            check(pattern, input, fIdx);
        }
    }
}
