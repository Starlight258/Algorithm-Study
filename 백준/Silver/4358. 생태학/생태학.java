import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> count = new TreeMap<>();
        long total = 0;

        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() == 0) continue;
            count.merge(line, 1, Integer::sum);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            double percent = (e.getValue() * 100.0) / total;
            sb.append(e.getKey())
              .append(' ')
              .append(String.format(Locale.US, "%.4f", percent))
              .append('\n');
        }
        System.out.print(sb.toString());
    }
}