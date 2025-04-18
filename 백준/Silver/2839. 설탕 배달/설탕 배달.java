import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 3) {
            System.out.println(-1);
            return;
        }
        int start = n / 5;
        while (start >= 0) {
            int remain = n - (start * 5);
            if (remain % 3 == 0) {
                System.out.println(start + (remain / 3));
                return;
            }
            start--;
        }
        System.out.println(-1);
    }
}
