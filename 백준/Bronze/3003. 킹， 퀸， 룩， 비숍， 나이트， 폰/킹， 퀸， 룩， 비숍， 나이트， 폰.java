import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final int[] counts = new int[]{1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        List<Integer> splittedNumbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 0; i < splittedNumbers.size(); i++) {
            System.out.print(counts[i] - splittedNumbers.get(i) + " ");
        }
    }
}
