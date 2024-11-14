import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> answers = new ArrayList<>();
        int[][] squares = new int[n][n];
        int num=1;
        int x = 0, y = -1;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if (i%3==0){
                    y++;
                } else if (i%3==1){
                    x++;
                } else {
                    y--; x--;
                }
                squares[y][x] = num++;
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (squares[i][j]==0) break;
                answers.add(squares[i][j]);
            }
        }
        return answers.stream().mapToInt(i->i).toArray();
    }
}