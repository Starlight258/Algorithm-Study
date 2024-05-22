import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 987654321;

    static int n, mp, mf, ms, mv;
    static int b, c, d, e, ret = INF, sum;
    static Food[] foods;
    static Map<Integer, List<List<Integer>>> retV = new HashMap<>();

    static class Food {
        int protein, fat, carbo, vitamin, cost;

        public Food(int protein, int fat, int carbo, int vitamin, int cost) {
            this.protein = protein;
            this.fat = fat;
            this.carbo = carbo;
            this.vitamin = vitamin;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] standard = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mp = standard[0];
        mf = standard[1];
        ms = standard[2];
        mv = standard[3];

        foods = new Food[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < (1 << n); i++) {
            b = c = d = e = sum = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(j + 1);
                    b += foods[j].protein;
                    c += foods[j].fat;
                    d += foods[j].carbo;
                    e += foods[j].vitamin;
                    sum += foods[j].cost;
                }
            }
            if (b >= mp && c >= mf && d >= ms && e >= mv) {
                if (sum <= ret) {
                    ret = sum;
                    retV.computeIfAbsent(ret, k -> new ArrayList<>()).add(list);
                }
            }
        }

        if (ret == INF) {
            System.out.println(-1);
            return;
        }
        // 사전순으로 정렬
        retV.get(ret).sort((l1, l2) -> {
            for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                int cmp = Integer.compare(l1.get(i), l2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(l1.size(), l2.size());
        });

        // 정답 출력
        System.out.println(ret);
        for (Integer e : retV.get(ret).get(0)) {
            System.out.print(e + " ");
        }
    }
}
