import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        row_begin--; row_end--;
        // 정렬
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[col-1] == b[col-1]){
                    return Integer.compare(b[0], a[0]);
                }
                return Integer.compare(a[col-1], b[col-1]);
            }
        });
  
        // row_begin~row_end에 대해 각 Si 구하기
        for (int r=row_begin;r<=row_end;r++){
            int si = 0;
            for (int idx=0;idx<data[row_begin].length;idx++){
                si += data[r][idx] % (r+1);
            }
            answer ^= si;
        }
        
        return answer;
    }
}