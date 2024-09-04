import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> words = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> dictionary = new ArrayList<>(words.keySet());
        dictionary.sort((o1, o2) -> {
            if (words.get(o2) != words.get(o1)) {
                return Integer.compare(words.get(o2), words.get(o1));
            }
            if (o1.length() != o2.length()) {
                return Integer.compare(o2.length(), o1.length());
            }
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : dictionary) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
