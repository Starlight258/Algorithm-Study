class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        
        // 최대 공약수 구하기
        int gcdNumber = gcd(Math.max(w, h), Math.min(w,h));

        // 제외되는 사각형 구하기
        answer = (long)w*h - (w+h-gcdNumber);
        return answer;
    }
    private int gcd(int number1, int number2){
        if (number1 % number2==0){
            return number2;
        }
        return gcd(number2, number1%number2);
    }
}