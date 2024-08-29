import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String defaultType = st.nextToken();
        StringBuilder result = new StringBuilder();
        while (st.hasMoreTokens()) {
            String type = st.nextToken();
            type = type.substring(0, type.length() - 1);
            String name = type;
            StringBuilder additionalType = new StringBuilder();
            for (int i = 0; i < type.length(); i++) {
                char c = type.charAt(i);
                if (c == '&' || c == '[' || c == '*') {
                    name = type.substring(0, i);
                    additionalType = new StringBuilder(type.substring(i));
                    break;
                }
            }
            StringBuilder reverse = new StringBuilder();
            for (int i = additionalType.length() - 1; i >= 0; i--) {
                if (additionalType.charAt(i) == ']') {
                    reverse.append("[]");
                    i--;
                } else {
                    reverse.append(additionalType.charAt(i));
                }
            }
            result.append(defaultType).append(reverse).append(" ").append(name).append(";").append("\n");
        }
        System.out.println(result);
    }
}
