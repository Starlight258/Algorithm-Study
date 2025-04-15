import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String LINE = System.lineSeparator();
    private static final String FORMAT = "%d * %d = %d" + LINE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 9; i++) {
            System.out.printf(FORMAT, number, i, number * i);
        }
    }
}
