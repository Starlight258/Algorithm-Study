public class Solution {
    public int solution(String name) {
        int alpha = 0;
        int minMove = name.length() - 1;

        for (int cursor = 0; cursor < name.length(); cursor++) {
            int nextCursor = cursor + 1;

            while (nextCursor < name.length() && name.charAt(nextCursor) == 'A') {
                nextCursor++;
            }

            int toBack = name.length() - nextCursor;

            // 앞으로만 직진할 때, 현재 위치에서 뒤로 이동(nextCursor까지), 먼저 뒤로 갔다가(nextCursor까지) 현재 위치로 이동
            minMove = Math.min(minMove, cursor * 2 + toBack);
            minMove = Math.min(minMove, toBack * 2 + cursor);

            int code = name.charAt(cursor) - 65;
            alpha += Math.min(code, 26 - code);
        }

        return alpha + minMove;
    }
}