class Solution {
    int gcd(int n, int m){
        int tmp = 0;
        while (m>0){
            tmp = n%m;
            n = m;
            m = tmp;
        }
        return n;
    }
    boolean checkCounterpart(int[] array, int num){
        for (int a:array){
            if (a % num == 0){
                return false;
            }
        }
        return true;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        //1. 최대공약수 구하기
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for(int a:arrayA){
            gcdA = gcd(gcdA, a);
        }
        for (int b:arrayB){
            gcdB = gcd(gcdB, b);
        }
                
        if (gcdA==1 && gcdB==1){
            return 0;
        }
        
        // 2. 조건 확인하기
        boolean checkA = checkCounterpart(arrayB, gcdA);
        boolean checkB = checkCounterpart(arrayA, gcdB);
        
        if (!checkA && !checkB) return 0;
        if (checkA && checkB) {
            return gcdA>gcdB ? gcdA : gcdB;
        }
        
        if (checkA) return gcdA;
        else return gcdB;
    }
}