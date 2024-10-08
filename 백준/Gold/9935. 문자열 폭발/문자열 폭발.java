import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            sb.append(words.charAt(i));

            if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
                sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
