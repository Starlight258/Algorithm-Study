class Solution {
    private int[] answer = null;
    private int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        int[] result = new int[11];
        dfs(0, 0, 0, result, info, n, 0);
        return answer != null ? answer : new int[]{-1};
    }

    private void dfs(int depth, int score, int num, int[] result, int[] info, int n, int apeach) {
        if (depth == info.length) {
            int diff = score - apeach;
            if (diff > 0 && diff >= maxDiff) {
                if (num < n) {
                    result[10] += n - num;
                }
                if (diff > maxDiff || isLowerScoreBetter(result, answer)) {
                    maxDiff = diff;
                    answer = result.clone();
                }
                if (num < n) {
                    result[10] -= n - num;
                }
            }
            return;
        }

        if (num + info[depth] + 1 <= n) {
            result[depth] = info[depth] + 1;
            dfs(depth + 1, score + 10 - depth, num + info[depth] + 1, result, info, n, apeach);
            result[depth] = 0;
        }

        if (info[depth] > 0) apeach += 10 - depth;
        dfs(depth + 1, score, num, result, info, n, apeach);
    }

    private boolean isLowerScoreBetter(int[] result, int[] answer) {
        if (answer == null) return true;
        for (int i = 10; i >= 0; i--) {
            if (result[i] > answer[i]) return true;
            if (result[i] < answer[i]) return false;
        }
        return false;
    }
}