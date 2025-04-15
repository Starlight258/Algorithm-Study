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
        int maxLength = number * 2 - 1;
        for (int i = 1; i <= number; i++) {
            makePyramid(i, maxLength, sb);
        }
        for (int i = number - 1; i >= 1; i--) {
            makePyramid(i, maxLength, sb);
        }
        System.out.println(sb);
    }

    private static void makePyramid(final int i, final int maxLength, final StringBuilder sb) {
        int startCount = i * 2 - 1;
        int blankCount = (maxLength - startCount) / 2;
        sb.append(BLANK.repeat(blankCount)).append(STAR.repeat(startCount)).append("\n");
    }
}
