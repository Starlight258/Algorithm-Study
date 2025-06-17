import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }
            String[] split = line.split(" ");
            int k = Integer.parseInt(split[0]);
            List<Integer> s = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                s.add(Integer.parseInt(split[i]));
            }

            dfs(s, 0, new ArrayList<>());
            System.out.println();
        }
    }

    private static void dfs(List<Integer> s, int start, List<Integer> temp) {
        if (temp.size() == 6) {
            for (Integer number : temp) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < s.size(); i++) {
            Integer e = s.get(i);
            temp.add(e);
            dfs(s, i + 1, temp);
            temp.remove(e);
        }
    }
}
