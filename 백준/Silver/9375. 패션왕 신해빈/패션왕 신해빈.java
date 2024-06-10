import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> mp = new HashMap<>();
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String genre = st.nextToken();
                mp.put(genre, mp.getOrDefault(genre, 0) + 1);
            }

            int answer = 1;
            for (Integer value : mp.values()) {
                answer *= value + 1;
            }
            System.out.println(answer - 1);
        }
    }
}
