import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String STAR = "*";
    private static final String BLANK = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(BLANK.repeat(i)).append(STAR.repeat(number - i)).append("\n");
        }
        System.out.println(sb);
    }
}
