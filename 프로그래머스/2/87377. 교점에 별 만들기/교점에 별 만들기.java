import java.util.*;
class Solution {
    static List<long[]> list = new ArrayList<>();
    public String[] solution(int[][] line) {
        List<String> answer = new ArrayList<>();
        //1. 정수 교점 구하기
        long a,b,c,d,e,f;
        for (int i=0;i<line.length;i++){
            for (int j=i+1;j<line.length;j++){
                a = (long)line[i][0]; b = (long)line[i][1]; e = (long)line[i][2];
                c = (long)line[j][0]; d = (long)line[j][1]; f = (long)line[j][2];

                long xNumer = ((long)b * f - (long)e * d); // 분자
                long Deno = ((long)a * d - (long)b * c); // 분모
                if (Deno==0) continue;
                if (xNumer % Deno != 0) continue; 
                long x = xNumer / Deno;
                
                long yNumer = ((long)e * c - (long)a * f);
                if (yNumer % Deno != 0) continue; 
                long y = yNumer / Deno;
                list.add(new long[]{x, y});
            }
        }
        //2. y 최대 최소 x 최대 최소 구하기
        long yMax=Long.MIN_VALUE,yMin=Long.MAX_VALUE;
        long xMax = Long.MIN_VALUE, xMin = Long.MAX_VALUE;
        for (long[] xy:list){
            long x = xy[0];
            long y = xy[1];
            xMax = Math.max(xMax, x);
            xMin = Math.min(xMin, x);
            yMax = Math.max(yMax, y);
            yMin = Math.min(yMin, y);
        }
        for (long i = yMax;i>=yMin;i--){
            StringBuffer sb = new StringBuffer();
            for (long j=xMin;j<=xMax;j++){
                if (containsList(new long[]{j,i})){
                    sb.append("*");
                } else sb.append(".");
            }
            answer.add(sb.toString());
        }
        return answer.toArray(new String[0]);
    }
    public boolean containsList(long[] array){
        for (long[] e:list){
            if (e[0]==array[0] && e[1]==array[1]) return true;
        }
        return false;
    }
}