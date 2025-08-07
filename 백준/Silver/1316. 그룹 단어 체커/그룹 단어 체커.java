import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        Set<Character> seen = new HashSet<>();
        char prev = 0;

        for (char ch : word.toCharArray()) {
            if (ch != prev) {
                if (seen.contains(ch)) {
                    return false;
                }
                seen.add(ch);
            }
            prev = ch;
        }

        return true;
    }
}