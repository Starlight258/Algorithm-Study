import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> mp1 = new HashMap<>();
        Map<Integer, String> mp2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            mp1.put(name, i);
            mp2.put(i, name);
        }

        // 문제
        for (int i = 0; i < m; i++) {
            String problem = br.readLine();
            if (!Character.isDigit(problem.charAt(0))) {
                System.out.println(mp1.get(problem));
            } else {
                System.out.println(mp2.get(Integer.parseInt(problem)));
            }
        }
    }
}
