import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int cnt = 1;
        int nowStart = targets[0][0];
        int nowEnd = targets[0][1];
        for (int[] target: targets){
            if (nowEnd <= target[0]){
                cnt++;
                nowStart = target[0];
                nowEnd = target[1];
            }
        }
        
        return cnt;
    }
}