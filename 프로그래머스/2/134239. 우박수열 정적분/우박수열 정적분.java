import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        // 우박 수열 구하기
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while (k != 1){
            if (k%2==0){
                k /= 2;
                list.add(k);
            } else {
                k = k*3+1;
                list.add(k);
            }
        }
        int n = list.size()-1;
        // 범위별 정적분하기
        for (int i=0;i<ranges.length;i++){
            int[] range = ranges[i];
            int s = range[0];
            int e = n + range[1];
            if (s>e) answer[i] = -1;
            else if (s==e) answer[i] = 0;
            else answer[i] = getArea(s, e, list);
        }
        
        return answer;
    }
    private double getArea(int s, int e, List<Integer> list){
        double val = 0;
        for (int i=s;i<e;i++){
            int v1 = list.get(i);
            int v2 = list.get(i+1);
            int min = Math.min(v1, v2);
            double diff = Math.abs(v2 - v1);
            val += min + diff / 2;
        }
        return val;
    }
}