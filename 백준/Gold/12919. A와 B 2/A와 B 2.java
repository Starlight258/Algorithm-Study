import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void dfs(String s, String cur) {
        if (cur.length() == s.length()) {
            if (cur.equals(s)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        if (cur.charAt(cur.length() - 1) == 'A') {
            dfs(s, cur.substring(0, cur.length() - 1));
        }
        if (cur.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(cur);
            cur = sb.reverse().deleteCharAt(sb.length() - 1).toString();
            dfs(s, cur);
        }
    }

    public static void main(String[] args) throws IOException {
        //1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        dfs(s, t);
        System.out.println(0);
    }
}
