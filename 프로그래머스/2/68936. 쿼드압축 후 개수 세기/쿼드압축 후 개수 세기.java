class Solution {
    static int[] dy = {0,0,1,1};
    static int[] dx = {0,1,0,1};
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        checkArea(arr, arr.length, 0, 0);
        return answer;
    }
    void checkArea(int[][] arr, int width, int y, int x){
        if (isMatched(arr, width, y, x)){
            answer[arr[y][x]]++;
            return;
        }
        checkArea(arr, width/2, y, x);
        checkArea(arr, width/2, y+width/2, x);
        checkArea(arr, width/2, y, x+width/2);
        checkArea(arr, width/2, y+width/2, x+width/2);
    }
    boolean isMatched(int[][] arr, int width, int y, int x){
        int e = arr[y][x];
        for (int i=y;i<y+width;i++){
            for (int j=x;j<x+width;j++){
                if (e!=arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}