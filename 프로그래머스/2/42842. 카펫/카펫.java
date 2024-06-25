class Solution {
    public int[] solution(int brown, int yellow) {
        //1. 갈색 블록으로 경우의 수 구하기
        int sum = (brown+4)/2;
        System.out.println(sum);
        for (int a=1;a<=sum/2;a++){
            int b = sum - a;
            if ((a-2) * (b-2) == yellow){
                if (a>=b){
                    return new int[]{a,b};
                }
                return new int[]{b,a};
            }
        }
        return new int[]{0,0};
    }
}