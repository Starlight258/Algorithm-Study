import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int cnt = 0;
        String middle = "";
        boolean isOdd = false;
        Map<String, Integer> mp = new HashMap<>();
        for (String s : str.split("")) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        for (Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                middle = entry.getKey();
                isOdd = true;
                if (cnt++ >= 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        // 팰린드롬 만들기
        StringBuilder p = new StringBuilder();
        for (Character key = 'A'; key <= 'Z'; key++) {
            if (mp.containsKey(String.valueOf(key))) {
                for (int j = 0; j < mp.get(String.valueOf(key)) / 2; j++) {
                    p.append(key);
                }
            }
        }
        StringBuilder original = new StringBuilder(p);
        p.reverse();
        if (isOdd) {
            original.append(middle);
        }
        original.append(p);

        // 정답 출력
        System.out.println(original);
    }
}