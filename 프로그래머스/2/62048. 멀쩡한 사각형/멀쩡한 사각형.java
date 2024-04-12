class Solution {
    int gcdFunction(int a, int b){
        if (b==0) return a;
        return gcdFunction(b, a%b);
    }
    public long solution(int w, int h) {
        long answer = (long) w * h;
        int gcdValue = gcdFunction(w, h);
        int nW = w / gcdValue;
        int nH = h / gcdValue;
        int nCnt = nW + nH -1;
        answer -= (long) nCnt * gcdValue;
        return answer;
    }
}