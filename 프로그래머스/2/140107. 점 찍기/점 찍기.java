class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dPowx = (long) Math.pow(d, 2) / (long) Math.pow(k, 2);
        for (int x=0;x<=d;x++){
            long xx = (long) Math.pow(x, 2);
            if (dPowx - xx < 0) continue;
            long maxY = (long) Math.sqrt(dPowx - xx);
            answer += maxY + 1;
        }
        return answer;
    }
}