import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static Character[] array;
    private static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
    private static int l;
    private static int c;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        array = new Character[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            array[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(array);

        StringBuilder result = new StringBuilder();
        bsfs(result, 0, 0, 0);
        System.out.println(sb);
    }

    private static void bsfs(final StringBuilder result, final int cur, final int vowel, final int cons) {
        if (result.length() == l) {
            if (vowel >= 1 && cons >= 2) {
                sb.append(result).append("\n");
            }
            return;
        }
        if (cur == c) {
            return;
        }
        for (int i = cur; i < c; i++) {
            Character text = array[i];
            result.append(text);
            if (vowels.contains(text)) {
                bsfs(result, i + 1, vowel + 1, cons);
            } else {
                bsfs(result, i + 1, vowel, cons + 1);
            }
            result.deleteCharAt(result.length() - 1);
        }
    }
}
