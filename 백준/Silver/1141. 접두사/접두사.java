import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i])) {
                    flag = true;
                }
            }
            if (!flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}
