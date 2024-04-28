// class Solution {
//     public int solution(int x, int y, int n) {
//         int answer = 0;
//         int dp[] = new int[y+1];
//         dp[x] = 0;
        
//         for (int i=x;i<=y;i++){
//             if (dp[i/2]>0 && i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
//             if (dp[i/3]>0 && i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
//             if (i-n>=0 && i>=x && dp[i-n]>0) dp[i] = Math.min(dp[i], dp[i-n]+1);
//         }
                                         
//         return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
//     }
// }
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private static final int MAX_VALUE = 1_000_000;
    private final int[] visitCount = new int[MAX_VALUE + 1];
    private final Queue<Integer> queue = new ArrayDeque<>();

    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }

    private int bfs(int source, int target, int n) {
        queue.add(source);
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (value == target) {
                return visitCount[value];
            }
            addQueue(target, value, value + n);
            addQueue(target, value, value * 2);
            addQueue(target, value, value * 3);
        }
        return -1;
    }

    private void addQueue(int target, int value, int nextValue) {
        if (nextValue <= target && visitCount[nextValue] == 0) {
            queue.add(nextValue);
            visitCount[nextValue] = visitCount[value] + 1;
        }
    }
}