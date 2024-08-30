import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static Map<String, String> mpB;
    static Map<String, String> mpC;

    public static void main(String[] args) throws IOException {
        // 명령어 구조 저장
        mpB = new HashMap<>();
        mpB.putAll(new HashMap<>() {
            {
                put("ADD", "00000");
                put("SUB", "00010");
                put("MOV", "00100");
                put("AND", "00110");
                put("OR", "01000");
                put("NOT", "01010"); // 특수한 경우
                put("MULT", "01100");
                put("LSFTL", "01110");
                put("LSFTR", "10000");
                put("ASFTR", "10010");
                put("RL", "10100");
                put("RR", "10110");
            }
        });
        mpC = new HashMap<>();
        mpC.putAll(new HashMap<>() {
            {
                put("ADDC", "00001");
                put("SUBC", "00011");
                put("MOVC", "00101");
                put("ANDC", "00111");
                put("ORC", "01001");
                put("MULTC", "01101");
                put("LSFTLC", "01111");
                put("LSFTRC", "10001");
                put("ASFTRC", "10011");
                put("RLC", "10101");
                put("RRC", "10111");
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            if (!Objects.equals(mpB.getOrDefault(command, "Nan"), "Nan")) {
                calculateWithB(command, i1, i2, i3);
            } else {
                calculateWithC(command, i1, i2, i3);
            }
        }
    }

    private static void calculateWithB(final String command, final int rd, final int ra, final int rb) {
        StringBuilder result = new StringBuilder();
        result.append(mpB.get(command)).append(0);
        result.append(makeBinaryFormat(rd, 3))
                .append(makeBinaryFormat(ra, 3))
                .append(makeBinaryFormat(rb, 3))
                .append(0);
        System.out.println(result);
    }

    private static void calculateWithC(final String command, final int rd, final int ra, final int rc) {
        StringBuilder result = new StringBuilder();
        result.append(mpC.get(command)).append(0);
        result.append(makeBinaryFormat(rd, 3))
                .append(makeBinaryFormat(ra, 3))
                .append(makeBinaryFormat(rc, 4));
        System.out.println(result);
    }

    private static String makeBinaryFormat(int num, int digit) {
        String binaryString = Integer.toBinaryString(num);
        if (binaryString.length() < digit) {
            return "0".repeat(digit - binaryString.length()) + binaryString;
        }
        return binaryString;
    }
}
