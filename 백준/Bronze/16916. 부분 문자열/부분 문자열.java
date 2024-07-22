import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        table = new int[p.length()];
        System.out.println(KMP(s, p));
    }

    private static int KMP(String s, String p) {
        table = makeTable(p);
        int idx = 0; // 패턴 인덱스

        for (int i = 0; i < s.length(); i++) { // 문자열 인덱스
            while (idx > 0 && s.charAt(i) != p.charAt(idx)) { // 일치하지 않으면 그 전 일치한 개수
                idx = table[idx - 1];
            }

            if (s.charAt(i) == p.charAt(idx)) {
                if (idx == p.length() - 1) { // 모든 패턴이 일치할 경우
                    idx = table[idx];
                    return 1;
                } else { // 패턴 인덱스 증가
                    idx++;
                }
            }
        }
        return 0;
    }

    private static int[] makeTable(String pattern) {
        int n = pattern.length();
        int idx = 0;

        for (int i = 1; i < n; i++) {
            while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}
