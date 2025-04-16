import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        Set<Integer> numbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toSet());

        int m = Integer.parseInt(br.readLine());
        String[] splittedM = br.readLine().split(" ");
        List<Integer> target = Arrays.stream(splittedM).map(Integer::parseInt).collect(Collectors.toList());
        for (Integer number : target) {
            System.out.println(numbers.contains(number) ? 1 : 0);
        }
    }
}
