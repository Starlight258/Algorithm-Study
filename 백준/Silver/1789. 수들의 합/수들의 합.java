import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long n = (long) Math.floor((-1 + Math.sqrt(1 + 8 * s)) / 2);
        System.out.println(n);
    }
}
