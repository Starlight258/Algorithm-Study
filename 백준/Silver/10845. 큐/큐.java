import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (n-- > 0) {
            String[] split = br.readLine().split(" ");
            if (split.length == 2) {
                deque.offerLast(Integer.parseInt(split[1]));
                continue;
            }
            switch (split[0]) {
                case "pop":
                    if (isEmpty(deque)) {
                        break;
                    }
                    System.out.println(deque.pollFirst());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    System.out.println(0);
                    break;
                case "front":
                    if (isEmpty(deque)) {
                        break;
                    }
                    System.out.println(deque.peekFirst());
                    break;
                case "back":
                    if (isEmpty(deque)) {
                        break;
                    }
                    System.out.println(deque.peekLast());
                    break;
            }

        }
    }

    private static boolean isEmpty(final Deque<Integer> deque) {
        if (deque.isEmpty()) {
            System.out.println(-1);
            return true;
        }
        return false;
    }
}
