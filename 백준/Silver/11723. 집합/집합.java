import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Integer> set = new HashSet<>();
    static Set<Integer> twentySet = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 20; i++) {
            twentySet.add(i);
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() > 1) {
                operate(st.nextToken(), st.nextToken());
            } else {
                operate(st.nextToken());
            }
        }

        bw.flush();
        bw.close();

    }

    private static void operate(String command, String element) throws IOException {
        int e = Integer.parseInt(element);
        switch (command) {
            case "add":
                set.add(e);
                break;
            case "remove":
                set.remove(e);
                break;
            case "check":
                bw.write(set.contains(e) ? "1\n" : "0\n");
                break;
            case "toggle":
                if (set.contains(e)) {
                    set.remove(e);
                } else {
                    set.add(e);
                }
                break;
        }
    }

    private static void operate(String command) {
        switch (command) {
            case "all":
                set = new HashSet<>(twentySet);
                break;
            case "empty":
                set.clear();
                break;
        }
    }
}
