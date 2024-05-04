import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        col-=1;
        row_begin--;
        row_end--;
        
        final int colFinal = col;
        Arrays.sort(data, (d1, d2) -> {
            if (d1[colFinal] == d2[colFinal]){
                return d2[0] - d1[0];
            }
            return d1[colFinal] - d2[colFinal];
        });
        
        int[] result = new int[row_end-row_begin+1];
        
        for (int i=row_begin;i<=row_end;i++){
            for (int j=0;j<data[i].length;j++){
                result[i-row_begin] += data[i][j] % (i+1);
            }
        }
        
        answer = result[0];
        
        if (result.length==0) return answer;
        
        for (int i=1;i<result.length;i++){
            answer ^= result[i];
        }
        
        return answer;
    }
}