import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);  // 사전 순
            }
            return a.length() - b.length();  // 길이 순
        });

        for (String word : list) {
            sb.append(word).append("\n");
        }

        System.out.print(sb);
    }
}