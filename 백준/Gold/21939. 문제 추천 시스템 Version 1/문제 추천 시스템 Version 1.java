import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, TreeSet<Integer>> levPerPro = new TreeMap<>();
        Map<Integer, Integer> proPerLv = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            levPerPro.computeIfAbsent(l, k -> new TreeSet<>()).add(p);
            proPerLv.put(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    levPerPro.computeIfAbsent(l, k -> new TreeSet<>()).add(p);
                    proPerLv.put(p, l);
                    break;
                case "recommend":
                    int v = Integer.parseInt(st.nextToken());
                    int level;
                    if (v == 1) {
                        level = levPerPro.lastKey();
                        System.out.println(levPerPro.get(level).last());
                    } else {
                        level = levPerPro.firstKey();
                        System.out.println(levPerPro.get(level).first());
                    }
                    break;
                case "solved":
                    int target = Integer.parseInt(st.nextToken());
                    level = proPerLv.get(target);
                    TreeSet<Integer> probs = levPerPro.get(level);
                    if (probs.size() == 1) {
                        proPerLv.remove(target);
                        levPerPro.remove(level);
                    } else {
                        probs.remove(target);
                        proPerLv.remove(target);
                    }
            }
        }

        // recommend x
        // x=1 : 가장 어려운 문제 번호
        // x=-1: 가장 쉬운 문제 번호
        // add P L : 문제번호, 난이도 추가
        // solved P : 문제번호 제거

        // TreeMap<Integer, TreeSet<Integer>> : 난이도, 문제 번호들
        // Map<Integer, Integer> : 문제 번호 - 난이도
    }
}
