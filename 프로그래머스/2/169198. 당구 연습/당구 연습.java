class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i=0;i<balls.length;i++){
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int curlen, len = Integer.MAX_VALUE;
            
            // 왼쪽 벽
            if (!(startY == targetY && targetX <= startX)){
                curlen = getDistance(startX, startY, -1 * targetX, targetY);
                len = Math.min(len, curlen);
            }
            
            // 오른쪽 벽
            if (!(startY == targetY && targetX >= startX)){
                curlen = getDistance(startX, startY, m + m - targetX, targetY);
                len = Math.min(len, curlen);
            }
            
            // 위쪽 벽
            if (!(startX == targetX && startY >= targetY)){
                curlen = getDistance(startX, startY, targetX, -1 * targetY);
                len = Math.min(len, curlen);
            }
            
            // 아래쪽 벽
            if (!(startX == targetX && startY <= targetY)){
                curlen = getDistance(startX, startY, targetX, n + n - targetY);
                len = Math.min(len, curlen);
            }
            answer[i] = len;
        }
        return answer;
    }
    private int getDistance(int startX, int startY, int targetX, int targetY){
        return (int) (Math.pow(startX - targetX, 2) + Math.pow(startY - targetY, 2));
    }
}